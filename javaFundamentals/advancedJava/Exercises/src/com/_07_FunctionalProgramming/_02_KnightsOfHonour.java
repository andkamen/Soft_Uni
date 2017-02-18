package com._07_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Consumer<String> print = message -> System.out.println("Sir " + message);

        for (String s : input) {
            print.accept(s);
        }
    }
}
