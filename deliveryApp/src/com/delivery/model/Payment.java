package com.delivery.model;

import com.delivery.enums.PaymentMode;
import com.delivery.enums.PaymentStatus;

public class Payment {
    private String id;
    private double amount;
    private PaymentStatus status;
    private PaymentMode mode;

    public Payment(String id, double amount, PaymentMode mode) {
        this.id = id;
        this.amount = amount;
        this.mode = mode;
        this.status = PaymentStatus.PENDING;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    // getters

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentMode getMode() {
        return mode;
    }
}
