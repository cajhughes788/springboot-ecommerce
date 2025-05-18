package com.wgu._8.ecommercebackend.dao;

import com.wgu._8.ecommercebackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
@CrossOrigin("http://localhost:4200")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
