package com._07_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class _04_FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lowerBound = scan.nextInt();
        int upperBound = scan.nextInt();
        scan.nextLine();
        String type = scan.nextLine();

        int[] numbers = IntStream.rangeClosed(lowerBound, upperBound).toArray();

        if (type.equals("odd")) {
            filter(numbers, x -> x % 2 != 0);
        } else if(type.equals("even")) {
            filter(numbers, x -> x % 2 == 0);
        }
    }

    public static void filter(int[] numbers, Predicate<Integer> predicate){
        for (int number : numbers) {
            if (predicate.test(number)){
                System.out.printf("%d ", number);
            }
        }
    }
}
