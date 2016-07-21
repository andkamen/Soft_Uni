package com.L01DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int totalDistance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.totalDistance = 0;
    }

    public boolean move(int distance){
        if (distance * fuelCost > fuelAmount){
            return false;
        }

        totalDistance += distance;
        fuelAmount -= distance * fuelCost;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.totalDistance);
    }
}