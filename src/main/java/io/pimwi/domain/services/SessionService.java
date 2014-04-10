package io.pimwi.domain.services;

import io.pimwi.domain.entities.Session;

public interface SessionService {

    /**
     * Retrieve a session and update timestamp.
     *
     * @param token The token last generated
     */
    Session getSession(String token);

    /**
     * Delete sessions in DB which timestamp is older than <code>Session.SESSION_DURATION</code>.<br/>
     * Warning : the cron expression should be coherent with <code>Session.SESSION_DURATION</code> constant.
     */
    void cleanUpOldSessions();

}
