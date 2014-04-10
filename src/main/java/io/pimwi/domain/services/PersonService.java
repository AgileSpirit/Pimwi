package io.pimwi.domain.services;

import io.pimwi.domain.entities.Person;
import io.pimwi.infra.util.ApplicationException;

import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 13:18
 */
public interface PersonService {

    List<Person> find(String sessionToken, String query) throws ApplicationException;

}
