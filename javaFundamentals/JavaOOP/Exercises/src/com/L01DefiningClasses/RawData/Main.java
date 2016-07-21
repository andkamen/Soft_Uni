package com.L01DefiningClasses.RawData;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputArgs = reader.readLine().split("\\s+");
            String model = inputArgs[0];

            int engineSpeed = Integer.valueOf(inputArgs[1]);
            int enginePower = Integer.valueOf(inputArgs[2]);
            int cargoWeight = Integer.valueOf(inputArgs[3]);
            String cargoType = inputArgs[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tire[] tires = new Tire[4];
            for (int j = 0; j < 4; j++) {
                double tirePressure = Double.valueOf(inputArgs[5]);
                int tireAge = Integer.valueOf(inputArgs[6]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires[j] = tire;
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String cargoType = reader.readLine();
        switch (cargoType) {
            case "fragile":
                cars.stream().filter(car -> car.getCargo().getCargoType().equals(cargoType)).filter(car -> {
                    for (Tire tire : car.getTires()) {
                        if (tire.getPressure() < 1) {
                            return true;
                        }
                    }
                    return false;
                }).forEach(c -> System.out.println(c.getModel()));
                break;

            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargo().getCargoType().equals(cargoType))
                        .filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(System.out::println);
                break;
        }

    }
}