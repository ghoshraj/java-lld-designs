package com.delivery.model;

public class Address {

    private String id;
    private String city;
    private String state;
    private String pincode;

    public Address(String id, String city, String state, String pincode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // getters & setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
