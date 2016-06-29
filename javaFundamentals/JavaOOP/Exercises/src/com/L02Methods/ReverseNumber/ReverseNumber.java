package com.L02Methods.ReverseNumber;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DecimalNumber num = new DecimalNumber(scan.nextDouble());

        num.reverseNumber();
    }
}
