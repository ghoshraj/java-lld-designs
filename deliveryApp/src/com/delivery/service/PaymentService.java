package com.delivery.service;

import com.delivery.model.Order;
import com.delivery.model.Payment;

public interface PaymentService {

    Payment processPayment(Order order);
}
