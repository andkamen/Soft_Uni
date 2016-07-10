package com.L06Polymorphism.Vehicle.models;

public class Car extends Vehicle {
    private final double CONDITIONER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public boolean drive(double distance){
        return super.drive(distance,CONDITIONER_FUEL_CONSUMPTION);
    }
}
