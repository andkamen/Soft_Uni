package com._01_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Integer pushCount = scan.nextInt();
        Integer popCount = scan.nextInt();
        Integer searchFor = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < pushCount; i++) {
            stack.push(scan.nextInt());
        }

        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }

        if (stack.contains(searchFor)) {
            System.out.println("true");
        } else if (stack.size() == 0) {
            System.out.println(0);
        } else {
            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i < pushCount - popCount; i++) {
                int num = stack.pop();
                if (num < smallest) {
                    smallest = num;
                }
            }
            System.out.println(smallest);

        }

    }
}
