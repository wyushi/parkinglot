package com.ood.parking.lot;

import java.util.ArrayList;
import java.util.List;

import com.ood.parking.vehicle.Vehicle;

public class ParkingManager {
    List<List<List<Vehicle>>> spots = new ArrayList<>();

    public ParkingManager(int numLevel, int numRows, int spotsPerRow) {
        this.spots = createAllSpots(numLevel, numRows, spotsPerRow);
    }

    private List<List<List<Vehicle>>> createAllSpots(int numLevel, int numRows, int spotsPerRow) {
        List<List<List<Vehicle>>> levels = new ArrayList<>();
        for (int i = 0; i < numLevel; i++) {
            levels.add(createALevel(numRows, spotsPerRow));
        }
        return levels;
    }

    private List<List<Vehicle>> createALevel(int numRows, int spotsPerRow) {
        List<List<Vehicle>> spots = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            spots.add(createARow(spotsPerRow));
        }
        return spots;
    }

    private List<Vehicle> createARow(int spotsPerRow) {
        List<Vehicle> row = new ArrayList<>();
        for (int j = 0; j < spotsPerRow; j++) {
            row.add(null);
        }
        return row;
    }

    public int getNumOfLevels() {
        return this.spots.size();
    }

    public int getNumOfRows() {
        if (this.spots.size() == 0) {
            return 0;
        }
        return this.spots.get(0).size();
    }

    public int getNumOfSpotsPerRow() {
        if (getNumOfRows() == 0) {
            return 0;
        }
        return this.spots.get(0).get(0).size();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return vehicle.park(this.spots);
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        boolean found = false;
        for (List<List<Vehicle>> level: spots) {
            for (List<Vehicle> row: level) {
                for (int i = 0; i < row.size(); i++) {
                    if (row.get(i) == vehicle) {
                        row.set(i, null);
                        found = true;
                    }
                }
            }
        }
        return found;
    }

    public void printParkingLot() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spots.size(); i++) {
            List<List<Vehicle>> level = spots.get(i);
            
            for (int j = 0; j < level.size(); j++) {
                List<Vehicle> row = level.get(j);
                sb.append(String.format("L%dR%d: ", i, j));
                
                for (int k = 0; k < row.size(); k++) {
                    Vehicle v = row.get(k);
                    if (v == null) {
                        sb.append("-");
                    } else {
                        sb.append(v.toShortString());
                    }
                    sb.append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
