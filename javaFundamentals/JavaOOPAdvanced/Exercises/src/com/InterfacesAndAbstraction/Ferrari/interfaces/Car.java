package com.InterfacesAndAbstraction.Ferrari.interfaces;

public interface Car {
    static final String MODEL = "488-Spider";

    String getDriverName();

    default String useBrakes() {
        return "Brakes!";
    }

    default String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }
}
