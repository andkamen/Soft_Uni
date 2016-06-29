package com.L02Methods.LastDigitName;

public class Number {
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public void getLastDigitName() {
        int lastDigit = this.num % 10;
        String digitName = "";
        switch (lastDigit) {
            case 1:
                digitName = "one";
                break;
            case 2:
                digitName = "two";
                break;
            case 3:
                digitName = "three";
                break;
            case 4:
                digitName = "four";
                break;
            case 5:
                digitName = "five";
                break;
            case 6:
                digitName = "six";
                break;
            case 7:
                digitName = "seven";
                break;
            case 8:
                digitName = "eight";
                break;
            case 9:
                digitName = "nine";
                break;
            case 0:
                digitName = "zero";
        }
        System.out.println(digitName);
    }
}
