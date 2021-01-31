package com.ood.parking.vehicle;

import java.util.List;

public abstract class SingleSpotVehicle extends Vehicle {

    protected int[] spot;

    public SingleSpotVehicle(String id) {
        super(id);
    }
    
    protected boolean parkSingleSpot(List<List<List<Vehicle>>> spots, double start) {
        for (int i = 0; i < spots.size(); i++) {
            List<List<Vehicle>> level = spots.get(i);
            
            for (int j = 0; j < level.size(); j++) {
                List<Vehicle> row = level.get(j);
                int k = (int)(row.size() * start);
                for (; k < row.size(); k++) {
                    if (row.get(k) == null) {
                        row.set(k, this);
                        this.spot = new int[] {i, j, k};
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
 