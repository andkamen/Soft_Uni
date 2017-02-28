package com._05_StringAndTextProcessing;

import java.util.Scanner;

public class _07_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numA = scan.nextLine();
        String numB = scan.nextLine();

        StringBuilder padding = new StringBuilder();
        for (int i = 0; i < Math.max(numA.length(), numB.length()); i++) {
            padding.append("0");
        }

        if (numA.length() > numB.length()) {
            numB = padding.toString().substring(numB.length()) + numB;
        } else {
            numA = padding.toString().substring(numA.length()) + numA;
        }

        //System.out.println(numA);
        //System.out.println(numB);

        int remainder = 0;
        StringBuilder result = new StringBuilder();
        for (int i = numA.length() - 1; i >= 0; i--) {
            int digitA = Integer.parseInt(Character.toString(numA.charAt(i)));
            int digitB = Integer.parseInt(Character.toString(numB.charAt(i)));
            int sum = digitA + digitB + remainder;
            remainder = 0;
            if (sum<10){
                result.append(sum);
            }
            else{
                result.append(sum%10);
                remainder=sum/10;
            }
        }
        if (remainder>0){
            result.append(remainder);
        }
        result.reverse();
        System.out.println(result.toString().replaceFirst("^0*", ""));
    }
}
