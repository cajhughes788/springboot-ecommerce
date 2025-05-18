package com.wgu._8.ecommercebackend.services;

import com.wgu._8.ecommercebackend.entities.Cart;
import com.wgu._8.ecommercebackend.entities.CartItem;
import com.wgu._8.ecommercebackend.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
