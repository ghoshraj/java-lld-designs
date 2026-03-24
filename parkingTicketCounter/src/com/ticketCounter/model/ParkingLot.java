package com.ticketCounter.model;

import java.util.List;

public class ParkingLot {

    private List<ParkingSlot> parkingSlots;

    public ParkingLot(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
