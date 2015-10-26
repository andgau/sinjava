package com.hp.idescat.cerda.metadata.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hp.idescat.cerda.metadata.model.Idioma;


@RepositoryRestResource(collectionResourceRel = "idioma", path = "idioma")
public interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long> {

  Page<Idioma> findAll(Pageable pageable);

  // Examples
  // http://localhost:8080/idioma/search/findByParamValue?paramValue=es
  // http://localhost:8080/idioma?page=0&size=2&sort=descripcion
  // http://localhost:8080/idioma?page=0&size=2&sort=paramValue

}
