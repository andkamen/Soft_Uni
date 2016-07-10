package com.L06Polymorphism.Vehicle.models;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double distance;

    public Vehicle() {
    }

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getDistance() {
        return distance;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if(!this.getClass().getSimpleName().equals("Truck")) {
            if (fuelQuantity < 0) {
                throw new IllegalArgumentException("Fuel must be a positive number");
            }
            if (fuelQuantity > this.getTankCapacity()) {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setDistance(double distance) {
        this.distance = distance;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public boolean drive(double distance, double additionalACCost) {
        double maxDistance = this.fuelQuantity / (this.fuelConsumption + additionalACCost);
        if (distance > maxDistance) {
            return false;
        }
        setFuelQuantity(this.fuelQuantity - (this.fuelConsumption + additionalACCost) * distance);
        this.distance += distance;
        return true;
    }

    public void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + fuel);
    }
}
