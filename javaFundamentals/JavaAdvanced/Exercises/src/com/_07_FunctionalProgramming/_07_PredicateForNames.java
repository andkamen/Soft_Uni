package com._07_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;

public class _07_PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxLength = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        filterNames(names, n -> n.length() <= maxLength);
    }
    private static void filterNames(String[] names, Predicate<String> predicate){
        for (String name : names) {
            if (predicate.test(name)){
                System.out.println(name);
            }
        }
    }
}
