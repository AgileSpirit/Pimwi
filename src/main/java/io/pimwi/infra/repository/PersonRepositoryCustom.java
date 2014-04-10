package io.pimwi.infra.repository;

import io.pimwi.domain.entities.Person;

import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 05/04/2014
 * Time: 20:36
 */
public interface PersonRepositoryCustom {

    List<Person> findByFirstNameOrLastName(String query);

    List<Person> findFriends(Long userId);

}
