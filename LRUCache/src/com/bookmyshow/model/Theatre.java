package com.bookmyshow.model;

import java.util.List;

public class Theatre {

    private String theatreId;
    private String name;
    private String city;
    private List<Screen> screens;

    public Theatre(String theatreId, String name, String city, List<Screen> screens) {
        this.theatreId = theatreId;
        this.name = name;
        this.city = city;
        this.screens = screens;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getCity() {
        return city;
    }
}