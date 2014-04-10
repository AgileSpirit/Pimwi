package io.pimwi.infra.repository;

import io.pimwi.domain.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository  extends PagingAndSortingRepository<User, Long> {

    User findByLogin(String login);

}
