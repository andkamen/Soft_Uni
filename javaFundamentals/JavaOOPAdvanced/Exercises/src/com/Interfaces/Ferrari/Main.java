package com.Interfaces.Ferrari;

import com.Interfaces.Ferrari.interfaces.Car;
import com.Interfaces.Ferrari.models.Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  IllegalClassFormatException {
        Scanner scan = new Scanner(System.in);

        String driverName = scan.nextLine();
        Ferrari ferrari = new Ferrari(driverName);
        System.out.println(ferrari);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
