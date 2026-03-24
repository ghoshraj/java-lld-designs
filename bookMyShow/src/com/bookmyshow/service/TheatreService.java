package com.bookmyshow.service;

import com.bookmyshow.model.Screen;
import com.bookmyshow.model.Theatre;

import java.util.List;

public class TheatreService {

    private List<Theatre> theatreList;

    public TheatreService(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }

    public List<Theatre> getTheatresByCity(String city) {
        if (theatreList == null) return List.of();
        return theatreList.stream().
                filter(theatre -> theatre.getCity().equals(city)).toList();
    }

    public List<Screen> getScreens(Theatre theatre) {
        return theatre.getScreens();
    }
}
