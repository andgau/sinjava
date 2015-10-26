package es.sinjava.jndiexample.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.sinjava.jndiexample.model.Defidioma;


@RepositoryRestResource(collectionResourceRel = "defidioma", path = "defidioma")
public interface DefIdiomaRepository extends PagingAndSortingRepository<Defidioma, Long> {

  Page<Defidioma> findAll(Pageable pageable);


}
