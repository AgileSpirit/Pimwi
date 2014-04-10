package io.pimwi.infra.repository;

import io.pimwi.domain.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, PersonRepositoryCustom {

}
