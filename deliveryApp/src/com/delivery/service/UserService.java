package com.delivery.service;

import com.delivery.model.Address;
import com.delivery.model.User;

import java.util.List;

public interface UserService {

    User registerUser(String name, String mobile);

    User getUserById(String userId);

    List<Address> getUserAddresses(String userId);

    void addAddress(String userId, Address address);
}