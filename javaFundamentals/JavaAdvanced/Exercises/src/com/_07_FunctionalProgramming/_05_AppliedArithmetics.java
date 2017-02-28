package com._07_FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class _05_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            String command = scan.nextLine();

            switch (command) {
                case "add":
                    executeCommand(numbers, x -> x + 1);
                    break;
                case "subtract":
                    executeCommand(numbers, x -> x - 1);
                    break;
                case "multiply":
                    executeCommand(numbers, x -> x * 2);
                    break;
                case "print":
                    executeConsumerCommand(numbers, e -> System.out.printf("%d ", e));
                    System.out.println();
                    break;
                case "end":
                    return;
                default:
                    break;

            }
        }
    }

    private static void executeCommand(int[] numbers, Function<Integer, Integer> func) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = func.apply(numbers[i]);
        }
    }

    private static void executeConsumerCommand(int[] numbers, Consumer<Integer> consumer) {
        for (int number : numbers) {
            consumer.accept(number);
        }
    }
}
