package io.pimwi.infra.repository;

import io.pimwi.domain.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 05/04/2014
 * Time: 20:37
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findByFirstNameOrLastName(String query) {
        return em.createNamedQuery("Person.findByFirstNameOrLastName").setParameter("query", query).getResultList();
    }

    @Override
    public List<Person> findFriends(Long userId) {
        String request = "SELECT p.* " +
                "FROM users AS u, persons AS p, friends AS f " +
                "WHERE u.id=:userId " +
                "AND f.user_id=u.id " +
                "AND p.id=f.person_id " +
                "ORDER BY p.firstName";

        Query query = em.createNativeQuery(request, Person.class);
        query.setParameter("userId", userId);

        List<Person> friends = query.getResultList();
        return friends;
    }
}
