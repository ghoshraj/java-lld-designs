package com.bookmyshow.service.impl;

import com.bookmyshow.model.User;
import com.bookmyshow.service.PaymentService;

public class UpiPaymentService implements PaymentService {

    @Override
    public boolean makePayment(User user, double amount) {

        // Simulate UPI validation
        System.out.println("Processing UPI payment for user: " + user.getName());

        // Assume always success for now
        System.out.println("Payment successful via UPI");

        return true;
    }
}