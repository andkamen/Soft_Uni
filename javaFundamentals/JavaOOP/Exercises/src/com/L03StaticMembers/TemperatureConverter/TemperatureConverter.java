package com.L03StaticMembers.TemperatureConverter;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(Integer temperature) {
        double convertedTemp = (double) (temperature - 32) * 5 / 9;
        return convertedTemp;
    }

    public static double celsiusToFahrenheit(Integer temperature) {
        double convertedTemp = (double) temperature * 9 / 5 + 32;
        return convertedTemp;
    }
}
