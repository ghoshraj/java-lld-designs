package com.splitwise.split;

import com.splitwise.model.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        setAmount(amount);
    }
}