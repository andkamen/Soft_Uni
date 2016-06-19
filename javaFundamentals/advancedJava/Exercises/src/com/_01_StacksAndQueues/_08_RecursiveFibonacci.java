package com._01_StacksAndQueues;

import java.util.Scanner;

public class _08_RecursiveFibonacci {

    private static long[] fibResult;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        fibResult = new long[n+2];
        fibResult[1] = 1;
        fibResult[2] = 2;
        long result = getFibonacci(n);
        System.out.println(result);
    }

    private static long getFibonacci(int n) {
        if (fibResult[n] != 0){
            return fibResult[n];
        }
        fibResult[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return fibResult[n];
    }
}
