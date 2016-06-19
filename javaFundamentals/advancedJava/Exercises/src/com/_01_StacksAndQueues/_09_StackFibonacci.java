package com._01_StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class _09_StackFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        if (n<2){
            System.out.println(1);
            return;
        }

        LinkedList<Long> stack = new LinkedList<>();
        stack.push(1l);
        stack.push(1l);

        int count = 1;
        while(count<n){
            long secondNum = stack.poll();
            long firstNum = stack.poll();

            stack.push(secondNum);
            stack.push(secondNum+firstNum);
            count++;
        }
        System.out.println(stack.poll());






    }
}
