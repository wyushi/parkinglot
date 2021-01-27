package com.ood.parking;

import com.ood.parking.vehicle.Bus;
import com.ood.parking.vehicle.Motorcycle;
import com.ood.parking.vehicle.Vehicle;

public final class App {

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(1, 2, 20);
        for (int i = 0; i < 15; i++) {
            pl.parkVehicle(new Motorcycle("motorcycle_" + i));
        }

        Vehicle bus0 = new Bus("bus_0");
        pl.parkVehicle(bus0);
        Vehicle motor = new Motorcycle("motorcycle_" + 15);
        pl.parkVehicle(motor);
        // for (int i = 0; i < 15; i++) {
        //     pl.parkVehicle(new Motorcycle("motorcycle_" + i));
        // }
        pl.parkVehicle(new Bus("bus_1"));
        pl.printParkingLot();

        boolean success = pl.unParkVehicle(bus0);
        System.out.println(success);
        success = pl.unParkVehicle(motor);
        System.out.println(success);
        pl.printParkingLot();
    }
}
