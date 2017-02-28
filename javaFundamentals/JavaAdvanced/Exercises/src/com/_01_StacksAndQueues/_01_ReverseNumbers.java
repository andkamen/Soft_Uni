package com._01_StacksAndQueues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for (Integer number : numbers) {
            stack.push(number);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
