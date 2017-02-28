package com._05_StringAndTextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class _04_TenToN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split("\\s+");

        BigInteger base = new BigInteger(data[0]);
        BigInteger number = new BigInteger(data[1]);

        StringBuilder result = new StringBuilder();

        while(number.compareTo(new BigInteger("0"))>0){
            BigInteger[] divAndRemainder = number.divideAndRemainder(base);
            result.append(divAndRemainder[1]);
            number = divAndRemainder[0];
        }

        result.reverse();
        System.out.println(result);
    }
}
