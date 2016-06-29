package com.L02Methods.ReverseNumber;

import java.util.Arrays;

public class DecimalNumber {
    private Double num;

    public DecimalNumber(double num) {
        this.num = num;
    }

    public void reverseNumber() {
        if (num - Math.floor(num) == 0) {
            Integer number = (int) Math.floor(num);
            System.out.println(new StringBuilder(number.toString()).reverse().toString());
        } else {
            System.out.println(new StringBuilder(num.toString()).reverse().toString());
        }
    }
}
