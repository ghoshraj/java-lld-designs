package com.ticketCounter.service;

import com.ticketCounter.enums.VehicleType;
import com.ticketCounter.model.ParkingLot;
import com.ticketCounter.model.ParkingSlot;
import com.ticketCounter.model.Ticket;
import com.ticketCounter.model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingService {

    Map<String, Ticket> stringTicketMap = new HashMap<>();
    private ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        // find available slot
        ParkingSlot availableSlot = findAvailableSlot();

        if (availableSlot == null) {
            throw new RuntimeException("Parking Full");
        }

        // assign vehicle to slot

        availableSlot.setVehicle(vehicle);
        availableSlot.setOccupied(true);

        // create ticket
        Ticket ticket = new Ticket(
                UUID.randomUUID().toString(),
                vehicle,
                availableSlot,
                LocalDateTime.now(),
                null,
                0.0
        );

        stringTicketMap.put(ticket.getTicketId(), ticket);
        // return ticket
        return ticket;
    }

    public double unparkVehicle(Ticket ticket) {

        ticket.setExitTime(LocalDateTime.now());
        ticket.setAmount(calculateFees(ticket));

        // release slot
        ticket.getParkingSlot().setOccupied(false);
        ticket.getParkingSlot().setVehicle(null);

        stringTicketMap.remove(ticket.getTicketId());
        return ticket.getAmount();
    }

    public double calculateFees(Ticket ticket) {
        LocalDateTime entry = ticket.getEntryTime();
        LocalDateTime exit = ticket.getExitTime();
        long hours = Math.max(1, Duration.between(entry, exit).toHours());

        if (VehicleType.BIKE == ticket.getVehicle().getVehicleType()) {
            return hours * 10;
        } else {
            return hours * 20;
        }
    }

    private ParkingSlot findAvailableSlot() {

        for (ParkingSlot slot : parkingLot.getParkingSlots()) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }
}
