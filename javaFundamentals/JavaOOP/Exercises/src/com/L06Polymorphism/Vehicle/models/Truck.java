package com.L06Polymorphism.Vehicle.models;

public class Truck extends Vehicle {
    private final double CONDITIONER_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }


    public boolean drive(double distance){
        return super.drive(distance,CONDITIONER_FUEL_CONSUMPTION);
    }

    public void refuel(double fuel) {
        super.refuel(fuel*0.95);
    }
}
