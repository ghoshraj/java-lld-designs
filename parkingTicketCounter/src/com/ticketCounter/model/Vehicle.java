package com.ticketCounter.model;

import com.ticketCounter.enums.VehicleType;

public class Vehicle {

    private String vehicleId;
    private VehicleType vehicleType;

    public Vehicle(String VehicleId, VehicleType vehicleType) {
        this.vehicleId = VehicleId;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
