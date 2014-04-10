package io.pimwi.application.controllers;

import io.pimwi.application.model.NewsModel;
import io.pimwi.domain.entities.News;
import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.services.NewsService;
import io.pimwi.domain.services.SessionService;
import io.pimwi.infra.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsPageController.class);

    @Inject
    NewsService newsService;

    @Inject
    SessionService sessionService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, ModelMap model) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String sessionToken = cookie.getValue();
            Session session = sessionService.getSession(sessionToken);
            if (session != null) {
                /**
                 *
                 */
                NewsModel news = new NewsModel();
                news.setPublisherId(session.getUserId());
                model.put("news", news);

                /**
                 *
                 */
                // Retrieve news from DB
                List<News> entities = newsService.getNewsFor(session.getUserId());
                // Convert into presentation objects
                List<NewsModel> newsList = convert(entities);
                LOGGER.info("Number of retrieved news = " + newsList.size());
                // Link to model to view
                model.addAttribute("newsList", newsList);
                return "news";
            }
        }
        return "redirect:/error";
    }

    private List<NewsModel> convert(List<News> entities) {
        List<NewsModel> models = new ArrayList<>();
        for (News entity : entities) {
            Person publisher = newsService.getNewsPublisher(entity.getId());
            NewsModel model = new NewsModel();
            model.setPublisherId(publisher.getId());
            model.setPublisherName(publisher.getFirstName() + " " + publisher.getLastName());
            model.setPublisherPicture(publisher.getPicture());
            model.setContent(entity.getContent());
            models.add(model);
        }
        return models;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request,  HttpServletResponse response, @ModelAttribute("news") NewsModel news, Map<String, Object> model) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String sessionToken = cookie.getValue();
            Session session = sessionService.getSession(sessionToken);
            if (session != null) {
                newsService.postNews(sessionToken, session.getUserId(), news.getContent());
                return "redirect:/news";
            }
        }
        return "redirect:/error";
    }

}
