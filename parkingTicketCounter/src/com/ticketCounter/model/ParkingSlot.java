package com.ticketCounter.model;

public class ParkingSlot {

    private String parkingId;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSlot(String parkingId, Vehicle vehicle, boolean isOccupied) {
        this.parkingId = parkingId;
        this.vehicle = vehicle;
        this.isOccupied = isOccupied;
    }

    public String getParkingId() {
        return parkingId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
