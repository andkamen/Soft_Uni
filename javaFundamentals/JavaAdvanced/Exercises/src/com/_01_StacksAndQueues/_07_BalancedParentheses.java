package com._01_StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _07_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> parentheses = new Stack<>();

        String input = reader.readLine();

        for (char c : input.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                parentheses.add(c);

            } else if (parentheses.isEmpty()) {
                System.out.println("NO");
                return;
            } else if (c == ']') {
                if (!parentheses.pop().equals('[')) {
                    System.out.println("NO");
                    return;
                }
            } else if (c == '}') {
                if (!parentheses.pop().equals('{')) {
                    System.out.println("NO");
                    return;
                }
            } else if (c == ')') {
                if (!parentheses.pop().equals('(')) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}
