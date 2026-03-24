package com.bookmyshow.service;

import com.bookmyshow.model.Movie;
import com.bookmyshow.model.Seat;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.Theatre;

import java.util.List;

public class ShowService {

    private List<Show> showList;

    public ShowService(List<Show> showList) {
        this.showList = showList;
    }

    public List<Show> getShowsByMovie(Movie movie) {
        String id = movie.getMovieId();
        return showList.stream().filter(show -> show.getMovie().getMovieId().equals(id)).toList();
    }

    public List<Show> getShowsByTheatre(Theatre theatre) {
        return showList.stream()
                .filter(show -> theatre.getScreens().contains(show.getScreen()))
                .toList();
    }

    public List<Seat> getAvailableSeats(Show show) {
        return show.getScreen().getSeats().stream()
                .filter(seat -> show.isSeatAvailable(seat))
                .toList();
    }
}
