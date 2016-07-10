package com.L06Polymorphism.Vehicle;

import com.L06Polymorphism.Vehicle.models.Bus;
import com.L06Polymorphism.Vehicle.models.Car;
import com.L06Polymorphism.Vehicle.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static Car car;
    private static Bus bus;
    private static Truck truck;
    private static DecimalFormat df = new DecimalFormat("0.######");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] vehicleInfo = reader.readLine().split("\\s+");
        car = new Car(Double.valueOf(vehicleInfo[1]), Double.valueOf(vehicleInfo[2]), Double.valueOf(vehicleInfo[3]));

        vehicleInfo = reader.readLine().split("\\s+");
        truck = new Truck(Double.valueOf(vehicleInfo[1]), Double.valueOf(vehicleInfo[2]), Double.valueOf(vehicleInfo[3]));

        vehicleInfo = reader.readLine().split("\\s+");
        bus = new Bus(Double.valueOf(vehicleInfo[1]), Double.valueOf(vehicleInfo[2]), Double.valueOf(vehicleInfo[3]));

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String action = input[0];
            String vehicle = input[1];
            double value = Double.valueOf(input[2]);

            switch (action) {
                case "Drive":
                    executeDriveCommand(vehicle, value);
                    break;

                case "Refuel":
                    executeRefuelCommand(vehicle, value);
                    break;

                case "DriveEmpty":
                    executeDriveEmptyCommand(vehicle, value);
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static void executeDriveEmptyCommand(String vehicle, double distance) {
        try {
            if (bus.driveEmpty(distance)) {
                System.out.printf("Bus travelled %s km%n", df.format(distance));
            } else {
                System.out.println("Bus needs refueling");
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void executeRefuelCommand(String vehicle, double fuel) {
        try {
            switch (vehicle) {
                case "Car":
                    car.refuel(fuel);
                    break;
                case "Truck":
                    truck.refuel(fuel);
                    break;
                case "Bus":
                    bus.refuel(fuel);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void executeDriveCommand(String vehicle, double distance) {
        try {
            switch (vehicle) {
                //TODO fix code repetition with reflection in Vehicle.drive method
                case "Car":
                    if (car.drive(distance)) {
                        System.out.printf("Car travelled %s km%n", df.format(distance));
                    } else {
                        System.out.println("Car needs refueling");
                    }
                    break;
                case "Truck":
                    if (truck.drive(distance)) {
                        System.out.printf("Truck travelled %s km%n", df.format(distance));
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                    break;
                case "Bus":
                    if (bus.drive(distance)) {
                        System.out.printf("Bus travelled %s km%n", df.format(distance));
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }


}
