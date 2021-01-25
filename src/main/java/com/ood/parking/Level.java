package com.ood.parking;

import java.util.ArrayList;
import java.util.List;

import com.ood.parking.vehicle.Vehicle;

public class Level {
    public List<List<Vehicle>> spots;
    public Level(int num_rows, int spots_per_row) {
        spots = new ArrayList<>();
        for (int i = 0; i < num_rows; i++) {
            List<Vehicle> row = new ArrayList<>();
            for (int j = 0; j < spots_per_row; j++) {
                row.add(null);
            }
            spots.add(row);
        }
    }
}
