package io.pimwi.infra.repository;

import io.pimwi.domain.entities.Session;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface SessionRepository extends PagingAndSortingRepository<Session, String> {

    Session findByUserId(Long userId);

    List<Session> findByTimestampBefore(Date date);

}
