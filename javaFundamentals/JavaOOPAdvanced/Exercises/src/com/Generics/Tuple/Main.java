package com.Generics.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split("\\s+");
        Tuple<String, String> nameAndAdress = new Tuple<>(String.format("%s %s", input1[0], input1[1]), input1[2]);
        System.out.println(nameAndAdress);

        String[] input2 = reader.readLine().split("\\s+");
        Tuple<String, Integer> beer = new Tuple<>(input2[0], Integer.parseInt(input2[1]));
        System.out.println(beer);

        String[] input3 = reader.readLine().split("\\s+");
        Tuple<Integer, Double> numbers = new Tuple<>(Integer.parseInt(input3[0]), Double.parseDouble(input3[1]));
        System.out.println(numbers);
    }
}
