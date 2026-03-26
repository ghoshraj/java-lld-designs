package com.delivery.model;

public class DeliveryPartner {
    private String id;
    private String name;
    private String mobile;
    private boolean available;

    public DeliveryPartner(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // getters


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
}
