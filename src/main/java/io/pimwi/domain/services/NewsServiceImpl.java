package io.pimwi.domain.services;

import io.pimwi.domain.entities.News;
import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.entities.User;
import io.pimwi.domain.factories.NewsFactory;
import io.pimwi.infra.repository.NewsRepository;
import io.pimwi.infra.repository.SessionRepository;
import io.pimwi.infra.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 13:19
 */
@Named
public class NewsServiceImpl implements NewsService {

    @Inject
    NewsRepository newsRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    SessionRepository sessionRepository;

    @Override
    public List<News> getNewsFor(Long userId) {
        return newsRepository.findNewsForUserOrItsContacts(userId);
    }

    @Override
    @Transactional
    public Person getNewsPublisher(Long newsId) {
        News news = newsRepository.findOne(newsId);
        User user = userRepository.findOne(news.getPublisher().getId());
        Person person = user.getIdentity();
        return person;
    }

    @Override
    @Transactional
    public void postNews(String token, Long publisherId, String content) {
        Session session = sessionRepository.findOne(token);
        if (session != null) {
            User user = userRepository.findOne(publisherId);
            user.add(NewsFactory.create(user, content));
        }
    }


}
