package io.pimwi.infra.repository;

import io.pimwi.domain.entities.News;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 16:38
 */
public class NewsRepositoryImpl implements NewsRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<News> findNewsForUserOrItsContacts(Long userId) {
        String request = "SELECT n.* " +
                "FROM news AS n " +
                "WHERE n.user_id=:userId " +
                "OR n.user_id " +
                "IN ( " +
                "  SELECT u.id " +
                "  FROM users AS u, persons AS p, friends AS f " +
                "  WHERE u.person_id=p.id " +
                "  AND p.id=f.person_id " +
                "  AND f.user_id=:userId " +
                ")" +
                "ORDER BY n.publicationdate DESC";
        Query query = em.createNativeQuery(request, News.class);
        query.setParameter("userId", userId);

        List<News> result = query.getResultList();
        return result;
    }
}
