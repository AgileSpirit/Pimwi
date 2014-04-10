package io.pimwi.infra.repository;

import io.pimwi.domain.entities.News;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NewsRepository extends PagingAndSortingRepository<News, Long>, NewsRepositoryCustom {

    List<News> findByPublisherId(Long userId);

}
