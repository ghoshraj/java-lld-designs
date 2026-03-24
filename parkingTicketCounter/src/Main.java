import com.ticketCounter.enums.VehicleType;
import com.ticketCounter.model.ParkingLot;
import com.ticketCounter.model.ParkingSlot;
import com.ticketCounter.model.Ticket;
import com.ticketCounter.model.Vehicle;
import com.ticketCounter.service.ParkingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            slots.add(new ParkingSlot("P" + i, null, false));
        }

        ParkingLot parkingLot = new ParkingLot(slots);

        // ✅ pass parkingLot here
        ParkingService parkingService = new ParkingService(parkingLot);

        Vehicle vehicle = new Vehicle("V1", VehicleType.CAR);

        Ticket ticket = parkingService.parkVehicle(vehicle);
        System.out.println("Parked with Ticket ID: " + ticket.getTicketId());

        // simulate time passing
        Thread.sleep(5000);

        double fee = parkingService.unparkVehicle(ticket);
        System.out.println("Parking Fee: ₹" + fee);
    }
}