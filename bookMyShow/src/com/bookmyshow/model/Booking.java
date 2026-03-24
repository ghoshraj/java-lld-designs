package com.bookmyshow.model;

import java.util.List;

public class Booking {

    private String bookingId;
    private User user;
    private Show show;
    private List<Seat> seats;
    private double totalAmount;

    public Booking(String bookingId, User user, Show show,
                   List<Seat> seats, double totalAmount) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}