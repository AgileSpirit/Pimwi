package io.pimwi.application.controllers;

import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.services.PersonService;
import io.pimwi.domain.services.SessionService;
import io.pimwi.infra.util.ApplicationException;
import io.pimwi.infra.util.CookieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 20:31
 */
@Controller
@RequestMapping("/search")
public class SearchPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsPageController.class);

    @Inject
    SessionService sessionService;

    @Inject
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, ModelMap model, String query) {
        Cookie cookie = CookieHelper.get(request, Session.SMART_SESSION_ID);
        if (cookie != null) {
            String token = cookie.getValue();
            Session session = sessionService.getSession(token);
            if (session != null) {
                try {
                    List<Person> persons = personService.find(token, query);
                    model.addAttribute("persons", persons);
                    return "search";
                } catch (ApplicationException e) {
                    return "redirect:/error";
                }
            }
        }
        return "redirect:/error";
    }


}
