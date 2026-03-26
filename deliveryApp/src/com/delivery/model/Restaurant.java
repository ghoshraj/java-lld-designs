package com.delivery.model;

public class Restaurant {

    private String id;
    private String name;
    private Menu menu;
    private String city;

    public Restaurant(String id, String name, Menu menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
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

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
