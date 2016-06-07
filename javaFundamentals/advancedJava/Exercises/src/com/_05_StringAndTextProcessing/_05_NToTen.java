package com._05_StringAndTextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class _05_NToTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split("\\s+");

        BigInteger base = new BigInteger(data[0]);
        BigInteger number = new BigInteger("0");

        int powOf =0;
        for (int i = data[1].length()-1; i >= 0 ; i--) {
            BigInteger baseMultiplier = base.pow(powOf++);
            String digit = Character.toString(data[1].charAt(i));
            number = number.add(new BigInteger(digit).multiply(baseMultiplier));
        }
        System.out.println(number);
    }
}
