package com.ood.parking;

import java.util.ArrayList;
import java.util.List;

import com.ood.parking.vehicle.Bus;
import com.ood.parking.vehicle.Vehicle;
import com.ood.parking.vehicle.VehicleSize;

public class ParkingLot {
    List<Level> levelList = new ArrayList<>();
    int numRows;
    int spotsPerRow;
    
    public ParkingLot(int n, int numRows, int spotsPerRow) {
        for (int i = 0; i < n; i++) {
            Level level = new Level(numRows, spotsPerRow);
            this.levelList.add(level);
        }
        this.numRows = numRows;
        this.spotsPerRow = spotsPerRow;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle.size == VehicleSize.Motorcycle) {
            return park(vehicle, 0);
        }
        if (vehicle.size == VehicleSize.Compact) {
            return park(vehicle, spotsPerRow / 4);
        }
        if (vehicle.size == VehicleSize.Large) {
            return parkBus((Bus) vehicle);
        }
        throw new RuntimeException();
    }

    private boolean park(Vehicle vehicle, int start) {
        for (Level level: levelList) {
            for (List<Vehicle> row: level.spots) {
                for (int i = start; i < row.size(); i++) {
                    if (row.get(i) == null) {
                        row.set(i, vehicle);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean parkBus(Bus bus) {
        for (Level level: levelList) {
            for (List<Vehicle> row: level.spots) {
                int start = -1;
                for (int i = spotsPerRow / 4; i < row.size(); i++) {
                    if (row.get(i) == null) {
                        if (start == -1) {
                            start = i;
                        } else {
                            if (i - start == 4) {
                                for (int j = start; j <= i; j++) {
                                    row.set(i, bus);
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

    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
    }
}