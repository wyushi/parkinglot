package com.ood.parking.vehicle;

import java.util.List;

public final class Motorcycle extends SingleSpotVehicle {
    
    public Motorcycle (String id) {
        super(id);
        this.size = VehicleSize.Motorcycle;
    }

    @Override
    public String toShortString() {
        return "M";
    }

    @Override
    public boolean park(List<List<List<Vehicle>>> spots) {
        return this.parkSingleSpot(spots, 0);
    }
}