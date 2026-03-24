package com.splitwise.model;

import com.splitwise.split.Split;
import com.splitwise.split.SplitType;

import java.util.List;

public class Expense {

    private String expenseId;
    private User paidBy;
    private double amount;
    private List<Split> splits;
    private SplitType splitType;

    public Expense(String expenseId, User paidBy, double amount,
                   List<Split> splits, SplitType splitType) {
        this.expenseId = expenseId;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
        this.splitType = splitType;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}