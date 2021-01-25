package com.ood.parking;

import com.ood.parking.vehicle.Motorcycle;

public final class App {

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(1, 2, 20);
        pl.parkVehicle(new Motorcycle("motorcycle_1"));
    }
}
