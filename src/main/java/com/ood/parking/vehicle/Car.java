package com.ood.parking.vehicle;

public class Car extends Vehicle {

    public Car (String id) {
        super(id);
        this.size = VehicleSize.Compact;
    }

    @Override
    public String toShortString() {
        return "C";
    }
}
