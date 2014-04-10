package io.pimwi.domain.services;

import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.User;
import io.pimwi.infra.util.ApplicationException;

import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 06/03/14
 * Time: 09:02
 */
public interface UserService {

    /**
     *
     * @param login The login of the user
     * @param password The password of the user
     * @return The user session token
     */
    String signIn(String login, String password) throws ApplicationException;

    /**
     *
     * @param sessionToken The user session token
     */
    void signOut(String sessionToken) throws ApplicationException;

    List<Person> findFriends(String sessionToken, Long userId) throws ApplicationException;

    void addFriend(String sessionToken, Long contactId) throws ApplicationException;

    void removeFriend(String sessionToken, Long contactId) throws ApplicationException;

    User get(String sessionToken, Long userId) throws ApplicationException;

    void update(String sessionToken, User user) throws ApplicationException;

}
