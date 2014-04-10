package io.pimwi.domain.factories;

import io.pimwi.domain.entities.News;
import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 10:25
 */
public class UserFactory {

    public static User create(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setIdentity(PersonFactory.create("N/A", "N/A", "N/A", "N/A"));
        user.setNews(new ArrayList<News>());
        user.setFriends(new HashSet<Person>());
        return user;
    }

    public static User create(String login, String password, String firstName, String lastName, String email) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setIdentity(PersonFactory.create(firstName, lastName, email, "N/A"));
        user.setNews(new ArrayList<News>());
        user.setFriends(new HashSet<Person>());
        return user;
    }

    public final static String LOGIN = "login";
    public final static String PASSWORD = "password";
    public final static String FIRST_NAME = "firstName";
    public final static String LAST_NAME = "lastName";
    public final static String EMAIL = "email";
    public final static String PHONE_NUMBER = "phoneNumber";
    public final static String PICTURE = "picture";

    public static User create(Map<String, String> characteristics) {
        User user = new User();
        String login = getCharacteristic(characteristics, LOGIN);
        String password = getCharacteristic(characteristics, PASSWORD);
        String firstName = getCharacteristic(characteristics, FIRST_NAME);
        String lastName = getCharacteristic(characteristics, LAST_NAME);
        String email = getCharacteristic(characteristics, EMAIL);
        String phoneNumber = getCharacteristic(characteristics, PHONE_NUMBER);
        String picture = getCharacteristic(characteristics, PICTURE);

        user.setLogin(login);
        user.setPassword(password);
        user.setIdentity(PersonFactory.create(firstName, lastName, email, phoneNumber, picture));
        user.setNews(new ArrayList<News>());
        user.setFriends(new HashSet<Person>());
        return user;
    }

    private static final String getCharacteristic(Map<String, String> characteristics, String key) {
        String value = characteristics.get(key);
        return value;
    }



}
