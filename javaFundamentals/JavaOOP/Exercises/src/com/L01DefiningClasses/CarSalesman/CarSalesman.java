package com.L01DefiningClasses.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Engine> engineData = new HashMap<>();
        ArrayList<Car> carData = new ArrayList<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] parameters = reader.readLine().split("\\s+");
            String model = parameters[0];
            Integer power = Integer.valueOf(parameters[1]);

            Engine engine = new Engine(model, power);

            if (parameters.length == 3) {
                if (isNumber(parameters[2])) {
                    engine = new Engine(model, power, Integer.valueOf(parameters[2]));
                } else {
                    engine = new Engine(model, power, parameters[2]);
                }
            }
            if (parameters.length == 4) {
                engine = new Engine(model, power, Integer.valueOf(parameters[2]), parameters[3]);
            }

            engineData.put(model, engine);
        }

        int m = Integer.valueOf(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] parameters = reader.readLine().split("\\s+");
            String model = parameters[0];
            Engine engine = engineData.get(parameters[1]);
            Car car = new Car(model, engine);

            if (parameters.length == 3) {
                if (isNumber(parameters[2])) {
                    car = new Car(model, engine, Integer.valueOf(parameters[2]));
                } else {
                    car = new Car(model, engine, parameters[2]);
                }
            }
            if (parameters.length == 4) {
                car = new Car(model, engine, Integer.valueOf(parameters[2]), parameters[3]);
            }

            carData.add(car);
        }


        for (Car car : carData) {
            System.out.print(car.toString());
        }
    }


    private static boolean isNumber(String argument) {
        try {
            Integer.valueOf(argument);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
