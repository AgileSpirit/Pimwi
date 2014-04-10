package io.pimwi.infra.repository;

import io.pimwi.domain.entities.News;

import java.util.List;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 16:38
 */
public interface NewsRepositoryCustom {

    List<News> findNewsForUserOrItsContacts(Long userId);

}
