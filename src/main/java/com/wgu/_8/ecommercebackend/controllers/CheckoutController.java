package com.wgu._8.ecommercebackend.controllers;

import com.wgu._8.ecommercebackend.services.Purchase;
import com.wgu._8.ecommercebackend.services.PurchaseResponse;
import com.wgu._8.ecommercebackend.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }

}

