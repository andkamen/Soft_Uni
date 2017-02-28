package com._07_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int divisor = Integer.parseInt(scan.nextLine());

        reverseAndExclude(numbers, x -> x % divisor != 0);
    }
    private static void reverseAndExclude(int[] numbers, Predicate<Integer> predicate){
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (predicate.test(numbers[i])){
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
