package com.ood.parking.lot;

import java.util.ArrayList;
import java.util.List;

import com.ood.parking.vehicle.Bus;
import com.ood.parking.vehicle.Vehicle;
import com.ood.parking.vehicle.VehicleSize;

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
        // 1. find me a spot
        // 2. put vehicle into the spot
        int[] spot = findASpot(vehicle.size, vehicle.requiredNumSpots);
        if (spot == null) { return false; }
        parkVehicleIntoSpot(vehicle, spot);
        return true;
    }

    private int[] findASpot(VehicleSize size, int requiredNumSpots) {
        return null;
    }

    private void parkVehicleIntoSpot(Vehicle vehicle, int[] spot) {}

    private boolean park(Vehicle vehicle, int start) {
        for (List<List<Vehicle>> level: spots) {
            for (List<Vehicle> row: level) {
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
        for (List<List<Vehicle>> level: spots) {
            for (List<Vehicle> row: level) {
                int start = -1;
                for (int i = getNumOfSpotsPerRow() * 3 / 4; i < row.size(); i++) {
                    if (row.get(i) == null) {
                        if (start == -1) {
                            start = i;
                        } else {
                            if (i - start == 4) {
                                for (int j = start; j <= i; j++) {
                                    row.set(j, bus);
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
