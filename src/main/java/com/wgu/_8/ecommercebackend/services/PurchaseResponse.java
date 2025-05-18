package com.wgu._8.ecommercebackend.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseResponse {

    @JsonProperty("orderTrackingNumber")
    private String trackingNumber;

    public PurchaseResponse(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
