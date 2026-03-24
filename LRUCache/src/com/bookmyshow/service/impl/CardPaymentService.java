package com.bookmyshow.service.impl;

import com.bookmyshow.model.User;
import com.bookmyshow.service.PaymentService;

public class CardPaymentService implements PaymentService {

    @Override
    public boolean makePayment(User user, double amount) {

        // Simulate card validation
        System.out.println("Processing Card payment for user: " + user.getName());

        // Assume success
        System.out.println("Payment successful via Card");

        return true;
    }
}