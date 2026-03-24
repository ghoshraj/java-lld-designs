package com.bookmyshow.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Show {

    private String showId;
    private Movie movie;
    private Screen screen;
    private Date startTime;

    // Seat availability per show
    private Set<Seat> bookedSeats = new HashSet<>();

    public Show(String showId, Movie movie, Screen screen, Date startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Set<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void bookSeat(Seat seat) {
        bookedSeats.add(seat);
    }

    public boolean isSeatAvailable(Seat seat) {
        return !bookedSeats.contains(seat);
    }
}