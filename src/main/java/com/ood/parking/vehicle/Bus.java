package com.ood.parking.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Bus extends Vehicle {

    List<int[]> spots;

    public Bus (String id) {
        super(id);
        this.size = VehicleSize.Large;
        this.spots = new ArrayList<>();
    }

    @Override
    public String toShortString() {
        return "B";
    }

    @Override
    public boolean park(List<List<List<Vehicle>>> spots) {
        for (int i = 0; i < spots.size(); i++) {
            List<List<Vehicle>> level = spots.get(i);
            
            for (int j = 0; j < level.size(); j++) {
                List<Vehicle> row = level.get(j);
                
                int start = -1;
                for (int k = row.size() * 3 / 4; k < row.size(); k++) {
                    if (row.get(k) == null) {
                        if (start == -1) {
                            start = k;
                        } else {
                            if (k - start == 4) {
                                for (int o = start; o <= k; o++) {
                                    row.set(o, this);
                                    this.spots.add(new int[] {i,j,o});
                                }
                                return true;
                            }
                        }
                    } else {
                        start = -1;
                    }
                }
            }
        }
        return false;
    }
}
