package es.sinjava.jndiexample.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.sinjava.jndiexample.model.Estadistica;


@RepositoryRestResource(collectionResourceRel = "estadistica", path = "estadistica")
public interface EstadisticaRepository extends PagingAndSortingRepository<Estadistica, Long> {

//  Page<Estadistica> findAll(Pageable pageable);


}
