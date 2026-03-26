package com.delivery.service;

import com.delivery.enums.PaymentMode;
import com.delivery.service.impl.CardPaymentService;
import com.delivery.service.impl.CashOnDeliveryService;
import com.delivery.service.impl.UpiPaymentService;

public class PaymentServiceResolver {

    public PaymentService resolve(PaymentMode mode) {

        if (mode == PaymentMode.UPI) {
            return new UpiPaymentService();
        } else if (mode == PaymentMode.CARD) {
            return new CardPaymentService();
        } else if (mode == PaymentMode.CASH_ON_DELIVERY) {
            return new CashOnDeliveryService();
        }

        throw new RuntimeException("Unsupported payment mode");
    }
}
