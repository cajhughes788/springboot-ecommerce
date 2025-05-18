package com.wgu._8.ecommercebackend.dao;

import com.wgu._8.ecommercebackend.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
@CrossOrigin("http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Integer> {
}

