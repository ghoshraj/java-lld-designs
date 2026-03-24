package com.bookmyshow.service;

import com.bookmyshow.model.Booking;
import com.bookmyshow.model.Seat;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {

    private Map<String, Booking> bookingMap = new HashMap<>();

    public Booking bookSeats(User user, Show show, List<Seat> seats) {
        // 1. Validate seats belong to screen
        for (Seat seat : seats) {
            if (!show.getScreen().getSeats().contains(seat)) {
                throw new RuntimeException("Invalid seat selected");
            }
        }

        // 2. Check availability
        for (Seat seat : seats) {
            if (!show.isSeatAvailable(seat)) {
                throw new RuntimeException("Seat already booked: " + seat.getSeatId());
            }
        }

        // 3. Book seats
        for (Seat seat : seats) {
            show.bookSeat(seat);
        }

        // 4. Calculate price (simple logic)
        double totalAmount = seats.size() * 100;
        Booking booking = new Booking(
                java.util.UUID.randomUUID().toString(),
                user,
                show,
                seats,
                totalAmount
        );
        bookingMap.put(booking.getBookingId(), booking);

        return booking;
    }

    public void cancelBooking(String bookingId) {

        Booking booking = bookingMap.get(bookingId);

        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        Show show = booking.getShow();

        // Free seats
        for (Seat seat : booking.getSeats()) {
            show.getBookedSeats().remove(seat);
        }

        // Remove booking
        bookingMap.remove(bookingId);
    }
}
