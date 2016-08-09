package com.EnumerationsAndAnnotations.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        TrafficLight[] trafficLights = new TrafficLight[input.length];

        for (int i = 0; i < input.length; i++) {
            trafficLights[i] = new TrafficLight(Signals.valueOf(input[i]));
        }


        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < input.length; j++) {
                trafficLights[j].update();
                System.out.printf("%s ", trafficLights[j]);
            }
            System.out.println();
        }
    }
}
