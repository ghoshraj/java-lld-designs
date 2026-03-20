package com.parkinglot.model;

public class ParkingSpot {

    boolean isOccupied;
    Vehicle vehicle;

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void park(Vehicle vehicle) {
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    public void leave() {
        this.isOccupied = false;
        this.vehicle = null;
    }
}
