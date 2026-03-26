package com.delivery.service.impl;

import com.delivery.enums.PaymentMode;
import com.delivery.enums.PaymentStatus;
import com.delivery.model.Order;
import com.delivery.model.OrderItem;
import com.delivery.model.Payment;
import com.delivery.service.PaymentService;

import java.util.UUID;

public class CardPaymentService implements PaymentService {

    @Override
    public Payment processPayment(Order order) {

        double amount = calculateAmount(order);

        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                amount,
                PaymentMode.CARD
        );

        // Simulate success
        payment.setStatus(PaymentStatus.SUCCESS);

        return payment;
    }

    private double calculateAmount(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
