import com.bookmyshow.model.*;
import com.bookmyshow.service.BookingService;
import com.bookmyshow.service.PaymentService;
import com.bookmyshow.service.ShowService;
import com.bookmyshow.service.impl.UpiPaymentService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("U1", "Rajesh");

        // 🎬 Movie
        Movie movie = new Movie("M1", "Avengers", 180);

        // 💺 Seats
        List<Seat> seats = Arrays.asList(
                new Seat("S1", SeatType.NORMAL),
                new Seat("S2", SeatType.NORMAL),
                new Seat("S3", SeatType.PREMIUM)
        );

        // 🎥 Screen
        Screen screen = new Screen("SC1", seats);

        // 🏢 Theatre
        Theatre theatre = new Theatre(
                "T1",
                "PVR",
                "Bangalore",
                List.of(screen)
        );

        // 🎟 Show
        Show show = new Show(
                "SH1",
                movie,
                screen,
                new Date()
        );

        // 📺 ShowService
        ShowService showService = new ShowService(List.of(show));

        // 💳 Choose Payment (UPI or Card)
        PaymentService paymentService = new UpiPaymentService();
        // PaymentService paymentService = new CardPaymentService();

        // 🎫 BookingService
        BookingService bookingService = new BookingService();

        // 🎯 Seats to book
        List<Seat> selectedSeats = List.of(seats.get(0), seats.get(1));

        try {
            double amount = selectedSeats.size() * 100;

            // 💳 Payment
            if (paymentService.makePayment(user1, amount)) {

                // 🎟 Booking
                Booking booking = bookingService.bookSeats(user1, show, selectedSeats);

                System.out.println("Booking Successful: " + booking.getBookingId());

                // ❌ Cancel example
                // bookingService.cancelBooking(booking.getBookingId());

            } else {
                System.out.println("Payment Failed");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 📊 Available seats after booking
        System.out.println("\nAvailable Seats:");
        showService.getAvailableSeats(show)
                .forEach(seat -> System.out.println(seat.getSeatId()));
    }
}