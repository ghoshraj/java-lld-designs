package com.splitwise.service;

import com.splitwise.model.Expense;
import com.splitwise.model.User;
import com.splitwise.split.*;

import java.util.*;

public class ExpenseManager {

    private Map<User, Map<User, Double>> balances = new HashMap<>();
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(User paidBy, double amount,
                           List<Split> splits, SplitType splitType) {

        int totalUsers = splits.size();

        if (splitType == SplitType.EQUAL) {
            double share = amount / totalUsers;
            for (Split split : splits) {
                split.setAmount(share);
            }
        }

        else if (splitType == SplitType.PERCENTAGE) {
            for (Split split : splits) {
                PercentageSplit ps = (PercentageSplit) split;
                double share = (amount * ps.getPercentage()) / 100;
                split.setAmount(share);
            }
        }

        // EXACT already has amount

        Expense expense = new Expense(UUID.randomUUID().toString(),
                paidBy, amount, splits, splitType);

        expenses.add(expense);

        // Update balances
        for (Split split : splits) {
            User user = split.getUser();
            if (user.equals(paidBy)) continue;

            balances.putIfAbsent(user, new HashMap<>());
            balances.putIfAbsent(paidBy, new HashMap<>());

            balances.get(user).put(paidBy,
                    balances.get(user).getOrDefault(paidBy, 0.0) + split.getAmount());

            balances.get(paidBy).put(user,
                    balances.get(paidBy).getOrDefault(user, 0.0) - split.getAmount());
        }
    }

    public void showBalances() {
        for (User user : balances.keySet()) {
            for (User other : balances.get(user).keySet()) {
                double amount = balances.get(user).get(other);
                if (amount > 0) {
                    System.out.println(user.getName() + " owes "
                            + other.getName() + " ₹" + amount);
                }
            }
        }
    }
}