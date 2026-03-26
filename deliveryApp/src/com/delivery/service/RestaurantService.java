package com.delivery.service;

import com.delivery.model.FoodItem;
import com.delivery.model.Menu;
import com.delivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getRestaurantsByCity(String city);

    Restaurant getRestaurantById(String restaurantId);

    void addRestaurant(Restaurant restaurant);

    Menu getMenuByRestaurantId(String restaurantId);

    List<FoodItem> searchFoodItems(String keyword);
}