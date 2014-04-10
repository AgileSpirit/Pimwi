package io.pimwi.domain.factories;

import io.pimwi.domain.entities.News;
import io.pimwi.domain.entities.User;

import java.util.Date;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 12:09
 */
public class NewsFactory {

    public static News create(User publisher, String content) {
        return create(publisher, content, null);
    }

    public static News create(User publisher, String content, Date publicationDate) {
        Date date = (publicationDate == null) ? new Date() : publicationDate;
        News news = new News();
        news.setPublisher(publisher);
        news.setContent(content);
        news.setPublicationDate(date);
        return news;
    }

}
