package com.L03StaticMembers.TemperatureConverter;


import java.util.Scanner;

import static com.L03StaticMembers.TemperatureConverter.TemperatureConverter.celsiusToFahrenheit;
import static com.L03StaticMembers.TemperatureConverter.TemperatureConverter.fahrenheitToCelsius;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }

            if (input[1].equals("Celsius")) {
                double convertedTemp = celsiusToFahrenheit(Integer.valueOf(input[0]));
                System.out.printf("%.2f Fahrenheit%n", convertedTemp);
            } else if (input[1].equals("Fahrenheit")) {
                double convertedTemp = fahrenheitToCelsius(Integer.valueOf(input[0]));
                System.out.printf("%.2f Celsius%n", convertedTemp);
            }
        }
    }
}
