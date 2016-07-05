package com.L02Methods.Fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startPos = Integer.valueOf(scan.nextLine());
        int endPos = Integer.valueOf(scan.nextLine());

        Fibonacci fibonacci = new Fibonacci();

        ArrayList<Long> result = fibonacci.getNumbersInRange(startPos,endPos);

        System.out.printf(result.toString().replace("[","").replace("]",""));

    }

}
