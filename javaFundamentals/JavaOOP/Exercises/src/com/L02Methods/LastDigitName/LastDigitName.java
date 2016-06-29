package com.L02Methods.LastDigitName;

import java.util.Scanner;

public class LastDigitName {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

        Number num = new Number(scan.nextInt());
        num.getLastDigitName();
    }
}
