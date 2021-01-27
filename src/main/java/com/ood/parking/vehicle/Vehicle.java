package com.ood.parking.vehicle;

public abstract class Vehicle {
    public String id;
    public VehicleSize size;
    public int requiredNumSpots;
    
    public Vehicle(String id) {
        this.id = id;
    }

    public abstract String toShortString();
}
