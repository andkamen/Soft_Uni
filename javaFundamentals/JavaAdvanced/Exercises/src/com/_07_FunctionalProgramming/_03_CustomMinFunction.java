package com._07_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        Scanner scan = new Scanner(line);

        List<Integer> numbers = new ArrayList<>();

        while (scan.hasNextInt()) {
            Integer n = scan.nextInt();
            numbers.add(n);
        }

        applyFunction(numbers, findMin);
    }

    private static void applyFunction(List<Integer> numbers, Function<List<Integer>, Integer> func) {
        Integer result = func.apply(numbers);
        if (result != null) {
            System.out.println(result);
        }
    }

    private static Function<List<Integer>, Integer> findMin = new Function<List<Integer>, Integer>() {

        public Integer apply(List<Integer> numbers) {
            if (numbers.size() == 0) {
                return null;
            }

            Integer min = Integer.MAX_VALUE;

            for (Integer i : numbers) {
                if (i < min) {
                    min = i;
                }
            }

            return min;
        }
    };
}

