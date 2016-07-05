package com.L02Methods.Fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    private int startPosition;
    private int endPosition;
    private static long[] fibResult;

    public Fibonacci() {
    }

    private void calculateFibonacci(int endPosition){
        fibResult = new long[endPosition+2];
        fibResult[1] = 1;
        fibResult[2] = 1;

        getFibonacci(endPosition);
    }
    private static long getFibonacci(int n) {
        if (fibResult[n] != 0){
            return fibResult[n];
        }
        fibResult[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return fibResult[n];
    }

    public ArrayList<Long> getNumbersInRange(int startPosition, int endPosition){
        ArrayList<Long> result = new ArrayList<>();
        calculateFibonacci(endPosition);

        for (int i = startPosition; i <endPosition ; i++) {
            result.add(fibResult[i]);
        }

        return result;
    }
}
