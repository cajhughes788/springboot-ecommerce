package com.wgu._8.ecommercebackend.dao;

import com.wgu._8.ecommercebackend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
