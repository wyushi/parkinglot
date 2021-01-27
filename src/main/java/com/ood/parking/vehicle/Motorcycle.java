package com.ood.parking.vehicle;

public class Motorcycle extends Vehicle {
    
    public Motorcycle (String id) {
        super(id);
        this.size = VehicleSize.Motorcycle;
    }

    @Override
    public String toShortString() {
        return "M";
    }
}