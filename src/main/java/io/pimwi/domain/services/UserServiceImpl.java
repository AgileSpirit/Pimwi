package io.pimwi.domain.services;

import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.domain.entities.User;
import io.pimwi.domain.factories.SessionFactory;
import io.pimwi.infra.repository.PersonRepository;
import io.pimwi.infra.repository.SessionRepository;
import io.pimwi.infra.repository.UserRepository;
import io.pimwi.infra.util.ApplicationException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    SessionRepository sessionRepository;

    @Inject
    PersonRepository personRepository;

    @Override
    public String signIn(String login, String password) throws ApplicationException {
        User user = userRepository.findByLogin(login);

        if (user == null || !user.getPassword().equals(password)) {
            throw new ApplicationException();
        }

        // Check if a current session is open, then retrieve it
        Session session = sessionRepository.findByUserId(user.getId());

        // The user has no opened session
        if (session == null) {

            // Generate a session token
            String token = Session.generateToken();

            // Instance a new session
            session = SessionFactory.create(token, user.getId());

            // Persist the session in DB
            session = sessionRepository.save(session);
        }

        return session.getToken();
    }

    @Override
    public void signOut(String token) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(token);

        if (session == null) {
            throw new ApplicationException();
        }

        // Remove the session
        sessionRepository.delete(session);
    }

    @Override
    public List<Person> findFriends(String sessionToken, Long userId) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(sessionToken);
        if (session == null) {
            throw new ApplicationException();
        }

        List<Person> friends = personRepository.findFriends(userId);

        return friends;
    }

    @Override
    @Transactional
    public void addFriend(String sessionToken, Long personId) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(sessionToken);
        if (session == null) {
            throw new ApplicationException();
        }

        User user = userRepository.findOne(session.getUserId());

        if (user.getIdentity().getId().equals(personId)) {
            throw new ApplicationException();
        }

        Person friend = personRepository.findOne(personId);
        user.add(friend);

        User contact = friend.getUser();
        contact.add(user.getIdentity());
    }

    @Override
    @Transactional
    public void removeFriend(String sessionToken, Long contactId) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(sessionToken);
        if (session == null) {
            throw new ApplicationException();
        }

        User user = userRepository.findOne(session.getUserId());
        Person friend = personRepository.findOne(contactId);
        user.remove(friend);

        User contact = friend.getUser();
        contact.remove(user.getIdentity());
    }

    @Override
    @Transactional
    public User get(String sessionToken, Long userId) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(sessionToken);
        if (session == null) {
            throw new ApplicationException();
        }

        User user = userRepository.findOne(userId);
        user.getIdentity();
        return user;
    }

    @Override
    @Transactional
    public void update(String sessionToken, User user) throws ApplicationException {
        // Retrieve the session
        Session session = sessionRepository.findOne(sessionToken);
        if (session == null) {
            throw new ApplicationException();
        }

        User entity = userRepository.findOne(session.getUserId());
        entity.getIdentity().setFirstName(user.getIdentity().getFirstName());
        entity.getIdentity().setLastName(user.getIdentity().getLastName());
        entity.getIdentity().setEmail(user.getIdentity().getEmail());
        entity.getIdentity().setPhoneNumber(user.getIdentity().getPhoneNumber());
        if (user.getIdentity().getPicture() != null) {
            entity.getIdentity().setPicture(user.getIdentity().getPicture());
        }
    }

}
