package io.pimwi.domain.services;

import io.pimwi.domain.entities.Person;
import io.pimwi.domain.entities.Session;
import io.pimwi.infra.repository.PersonRepository;
import io.pimwi.infra.repository.SessionRepository;
import io.pimwi.infra.util.ApplicationException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 04/04/2014
 * Time: 20:50
 */
@Named
public class PersonServiceImpl implements PersonService {

    @Inject
    SessionRepository sessionRepository;

    @Inject
    PersonRepository personRepository;

    @Override
    public List<Person> find(String token, String query) throws ApplicationException {
        Session session = sessionRepository.findOne(token);
        if (session != null) {
            return personRepository.findByFirstNameOrLastName("%" + query.toUpperCase() + "%");
        }
        throw new ApplicationException();
    }
}
