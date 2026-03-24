package com.splitwise.split;

import com.splitwise.model.User;

public abstract class Split {

    private User user;
    private double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}