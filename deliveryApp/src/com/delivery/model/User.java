package com.delivery.model;

import java.util.List;

public class User {

    private String id;
    private String name;
    private String mobile;
    private List<Address> addresses;

    public User(String id, String name, String mobile, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    // getters & setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
