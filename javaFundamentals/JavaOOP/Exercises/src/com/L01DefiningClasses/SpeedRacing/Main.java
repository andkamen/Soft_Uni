package com.L01DefiningClasses.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        HashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputParams = reader.readLine().split("\\s+");

            String model = inputParams[0];
            double fuelAmount = Double.valueOf(inputParams[1]);
            double fuelCost = Double.valueOf(inputParams[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        while (true) {
            String input = reader.readLine();
            if (input.equals("End")) {
                break;
            }

            String[] inputParams = input.split("\\s+");
            String model = inputParams[1];
            int distance = Integer.valueOf(inputParams[2]);

            Car car = cars.get(model);
            if (!car.move(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.println(car.getValue());
        }
    }
}
