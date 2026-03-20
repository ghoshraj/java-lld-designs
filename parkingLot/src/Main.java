import com.parkinglot.model.Vehicle;
import com.parkinglot.service.ParkingLot;

public class Main {
    public static void main(String[] args) {

        // Create parking lot with capacity 3
        ParkingLot parkingLot = new ParkingLot(3);

        // Create vehicles
        Vehicle v1 = new Vehicle("CAR");
        Vehicle v2 = new Vehicle("BIKE");
        Vehicle v3 = new Vehicle("CAR");
        Vehicle v4 = new Vehicle("BIKE");

        // Park vehicles
        parkingLot.park(v1);
        parkingLot.park(v2);
        parkingLot.park(v3);

        // Try parking when full
        parkingLot.park(v4);

        // Remove a vehicle
        parkingLot.leave(v1);

        // Park again after freeing space
        parkingLot.park(v4);
    }
}