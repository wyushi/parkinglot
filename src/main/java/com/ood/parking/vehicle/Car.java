package com.ood.parking.vehicle;

import java.util.List;

public final class Car extends SingleSpotVehicle {

    public Car (String id) {
        super(id);
        this.size = VehicleSize.Compact;
    }

    @Override
    public String toShortString() {
        return "C";
    }

    @Override
    public boolean park(List<List<List<Vehicle>>> spots) {
        return this.parkSingleSpot(spots, 0.25f);
    }
}
