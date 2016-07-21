package com.Interfaces.Ferrari.models;

import com.Interfaces.Ferrari.interfaces.Car;

public class Ferrari implements Car {
    private String driverName;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.MODEL, this.useBrakes(), this.pushTheGasPedal(), this.driverName);
    }
}
