package com.wgu._8.ecommercebackend.services;

import com.wgu._8.ecommercebackend.dao.CustomerRepository;
import com.wgu._8.ecommercebackend.dao.DivisionRepository;
import com.wgu._8.ecommercebackend.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        try {
            Customer customer = purchase.getCustomer();
            Cart cart = purchase.getCart();
            Set<CartItem> cartItems = purchase.getCartItems();

            if (customer == null) {
                return new PurchaseResponse("ERROR: Customer is null.");
            }

            if (cart == null || cartItems == null || cartItems.isEmpty()) {
                return new PurchaseResponse("ERROR: Cart is empty.");
            }

            if (customer.getPostal_code() == null || customer.getPostal_code().isBlank()) {
                customer.setPostal_code("99999");
            }

            if (customer.getPhone() == null || customer.getPhone().isBlank()) {
                customer.setPhone("123-456-7890");
            }

            if (customer.getAddress() == null || customer.getAddress().isBlank()) {
                customer.setAddress("456 This St");
            }

            if (customer.getDivision() == null) {
                Division defaultDivision = divisionRepository.findById(2L)
                        .orElseThrow(() -> new IllegalArgumentException("Default Division ID 2 not found"));
                customer.setDivision(defaultDivision);
            }

            String trackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(trackingNumber);
            cart.setStatus(CartStatus.ordered);

            for (CartItem item : cartItems) {
                cart.add(item);
            }

            customer.add(cart);
            customerRepository.save(customer);

            return new PurchaseResponse(trackingNumber);

        } catch (Exception e) {
            return new PurchaseResponse("ERROR: " + e.getMessage());
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
