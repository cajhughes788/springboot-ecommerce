package com.wgu._8.ecommercebackend.services;

import com.wgu._8.ecommercebackend.services.Purchase;
import com.wgu._8.ecommercebackend.services.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
