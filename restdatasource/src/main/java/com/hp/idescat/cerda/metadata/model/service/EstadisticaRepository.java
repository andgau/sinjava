package com.hp.idescat.cerda.metadata.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hp.idescat.cerda.metadata.model.Estadistica;


@RepositoryRestResource(collectionResourceRel = "estadistica", path = "estadistica")
public interface EstadisticaRepository extends PagingAndSortingRepository<Estadistica, Long> {

//  Page<Estadistica> findAll(Pageable pageable);


}
