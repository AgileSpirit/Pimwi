package io.pimwi.domain.factories;

import io.pimwi.domain.entities.Session;

import java.util.Date;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 10:51
 */
public class SessionFactory {
    public static Session create(String token, Long userId) {
        Session session = new Session();
        session.setToken(token);
        session.setUserId(userId);
        session.setTimestamp(new Date());
        return session;
    }

}
