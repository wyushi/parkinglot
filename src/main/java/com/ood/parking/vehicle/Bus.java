package com.ood.parking.vehicle;

public class Bus extends Vehicle {

    public Bus (String id) {
        super(id);
        this.size = VehicleSize.Large;
    }

    @Override
    public String toShortString() {
        return "B";
    }
}
