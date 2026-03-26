package com.delivery.model;

import java.util.List;

public class Menu {
    private String id;
    private List<FoodItem> foodItems;

    public Menu(String id, List<FoodItem> foodItems) {
        this.id = id;
        this.foodItems = foodItems;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    // getters & setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
