package com.ood.parking.vehicle;

import java.util.List;

public abstract class Vehicle {
    public String id;
    public VehicleSize size;
    public int requiredNumSpots;
    
    public Vehicle(String id) {
        this.id = id;
    }

    public abstract String toShortString();

    public abstract boolean park(List<List<List<Vehicle>>> spots);
}