package com.wgu._8.ecommercebackend.dao;

import com.wgu._8.ecommercebackend.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(path = "divisions", collectionResourceRel = "divisions")
public interface DivisionRepository extends JpaRepository<Division, Long> {

    List<Division> findByCountryId(Long countryId);

}
