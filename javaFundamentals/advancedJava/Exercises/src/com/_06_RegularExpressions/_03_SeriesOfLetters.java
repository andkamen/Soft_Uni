package com._06_RegularExpressions;

import java.util.Scanner;

public class _03_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String result = input.replaceAll("(.)\\1+","$1");
        System.out.println(result);
    }
}
