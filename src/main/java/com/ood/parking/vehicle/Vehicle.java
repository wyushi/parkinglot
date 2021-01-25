package com.ood.parking.vehicle;

public abstract class Vehicle {
    public String id;
    public VehicleSize size;
    
    public Vehicle(String id) {
        this.id = id;
    }
}
