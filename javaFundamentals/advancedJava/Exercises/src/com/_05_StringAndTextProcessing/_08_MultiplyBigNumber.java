package com._05_StringAndTextProcessing;

import java.util.Scanner;

public class _08_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numA = scan.nextLine();
        int numB = scan.nextInt();

        //System.out.println(numA);
        //System.out.println(numB);
        if (numB==0){
            System.out.println(0);
            return;
        }
        int remainder = 0;
        StringBuilder result = new StringBuilder();
        for (int i = numA.length() - 1; i >= 0; i--) {
            int digitA = Integer.parseInt(Character.toString(numA.charAt(i)));
            int multi = digitA*numB + remainder;
            if (multi<10){
                result.append(multi);
                remainder=0;
            }
            else{
                result.append(multi%10);
                remainder=multi/10;
            }
        }
        if (remainder>0){
            result.append(remainder);
        }
        result.reverse();
        System.out.println(result.toString().replaceFirst("^0*", ""));
    }
}
