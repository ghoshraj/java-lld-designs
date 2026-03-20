package com.parkinglot.service;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;

public class ParkingLot {

    private ParkingSpot[] parkingSpot;

    public ParkingLot(int capacity){
        parkingSpot = new ParkingSpot[capacity];
        for(int i = 0; i < capacity; i++){
            parkingSpot[i] = new ParkingSpot();
        }
    }

    public void park(Vehicle vehicle){
        for (ParkingSpot spot : parkingSpot){
            if (!spot.isOccupied()) {
                spot.park(vehicle);
                System.out.println("Vehicle parked successfully");
                return;
            }
        }
        System.out.println("Parking lot is full");
    }

    public void leave(Vehicle vehicle){
        for (ParkingSpot spot : parkingSpot){
            if (spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
                spot.leave();
                System.out.println("Vehicle left successfully");
                return;
            }
        }
    }
}
