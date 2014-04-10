package io.pimwi.domain.services;

import io.pimwi.domain.entities.News;
import io.pimwi.domain.entities.Person;

import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 13:18
 */
public interface NewsService {

    List<News> getNewsFor(Long userId);

    Person getNewsPublisher(Long newsId);

    void postNews(String sessionToken, Long publisherId, String content);

}
