package com.L06Polymorphism.Vehicle.models;

public class Bus extends Vehicle {
    private final double CONDITIONER_FUEL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public boolean drive(double distance) {
        return super.drive(distance, CONDITIONER_FUEL_CONSUMPTION);
    }

    public boolean driveEmpty(double distance) {
        return super.drive(distance, 0);
    }
}
