package com.delivery.service.impl;

import com.delivery.model.FoodItem;
import com.delivery.model.Menu;
import com.delivery.model.Restaurant;
import com.delivery.service.RestaurantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {

    private Map<String, Restaurant> restaurantMap = new HashMap<>();

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        List<Restaurant> result = new ArrayList<>();

        for (Restaurant restaurant : restaurantMap.values()){
            if (restaurantMap.get(city).equals(city))
                result.add(restaurant);
        }
        return result;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant getRestaurantById(String restaurantId) {
        return restaurantMap.get(restaurantId);
    }

    @Override
    public Menu getMenuByRestaurantId(String restaurantId) {
        return restaurantMap.get(restaurantId).getMenu();
    }

    @Override
    public List<FoodItem> searchFoodItems(String keyword) {

        List<FoodItem> result = new ArrayList<>();

        for (Restaurant restaurant : restaurantMap.values()) {
            Menu menu = restaurant.getMenu();

            if (menu != null) {
                for (FoodItem item : menu.getFoodItems()) {
                    if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(item);
                    }
                }
            }
        }

        return result;
    }
}
