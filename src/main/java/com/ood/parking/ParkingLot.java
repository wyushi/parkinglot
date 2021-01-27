package com.ood.parking;

import com.ood.parking.lot.ParkingManager;
import com.ood.parking.vehicle.Vehicle;

public class ParkingLot { // Facade

    ParkingManager parkingManager;

    public ParkingLot(int n, int numRows, int spotsPerRow) {
        this.parkingManager = new ParkingManager(n, numRows, spotsPerRow);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return this.parkingManager.parkVehicle(vehicle);
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        return this.parkingManager.unParkVehicle(vehicle);
    }

    public void printParkingLot() {
        this.parkingManager.printParkingLot();
    }
}