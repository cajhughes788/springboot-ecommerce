package com.wgu._8.ecommercebackend.dao;

import com.wgu._8.ecommercebackend.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(path = "vacations", collectionResourceRel = "vacations")
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
