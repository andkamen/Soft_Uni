package com.Generics.Triple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split("\\s+");
        Triple<String, String, String> nameAndAdress = new Triple<>(String.format("%s %s", input1[0], input1[1]), input1[2], input1[3]);
        System.out.println(nameAndAdress);

        String[] input2 = reader.readLine().split("\\s+");
        Triple<String, Integer, Boolean> drinkingPerson = new Triple<>(input2[0], Integer.parseInt(input2[1]), input2[2].equals("drunk"));
        System.out.println(drinkingPerson);

        String[] input3 = reader.readLine().split("\\s+");
        Triple<String, Double, String> bankAccount = new Triple<>(input3[0], Double.parseDouble(input3[1]), input3[2]);
        System.out.println(bankAccount);
    }
}
