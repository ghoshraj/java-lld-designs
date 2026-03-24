package com.bookmyshow.service;

import com.bookmyshow.model.User;

public interface PaymentService {

    boolean makePayment(User user, double amount);
}
