package com.L03StaticMembers.BasicMath;

import java.util.Scanner;

import static com.L03StaticMembers.BasicMath.MathUtils.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }
            String operation = input[0];
            double firstNum = Double.valueOf(input[1]);
            double secondNum = Double.valueOf(input[2]);

            switch (operation){
                case "Sum":
                    System.out.printf("%.2f%n",sum(firstNum,secondNum));
                    break;
                case "Subtract":
                    System.out.printf("%.2f%n",subtract(firstNum,secondNum));
                    break;
                case "Multiply":
                    System.out.printf("%.2f%n",multiply(firstNum,secondNum));
                    break;
                case "Divide":
                    System.out.printf("%.2f%n",divide(firstNum,secondNum));
                    break;
                case "Percentage":
                    System.out.printf("%.2f%n",percentage(firstNum,secondNum));
                    break;
            }
        }
    }
}
