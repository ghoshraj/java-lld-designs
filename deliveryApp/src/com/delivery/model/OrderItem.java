package com.delivery.model;

public class OrderItem {
    private String id;
    private FoodItem foodItem;
    private int quantity;
    private double price; // snapshot price

    public OrderItem(String id, FoodItem foodItem, int quantity) {
        this.id = id;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = foodItem.getPrice();
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    // getters

    public String getId() {
        return id;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
