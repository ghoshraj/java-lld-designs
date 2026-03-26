package com.delivery.service.impl;

import com.delivery.model.Address;
import com.delivery.model.User;
import com.delivery.service.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public User registerUser(String name, String mobile) {
        String userId = UUID.randomUUID().toString();
        List<Address> addresses = new ArrayList<>();
        User user = new User(userId, name, mobile, addresses);
        userMap.put(userId, user);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    @Override
    public List<Address> getUserAddresses(String userId) {
        return userMap.get(userId).getAddresses();
    }

    @Override
    public void addAddress(String userId, Address address) {
        User user = userMap.get(userId);
        if (user != null) {
            user.getAddresses().add(address);
        }
    }
}
