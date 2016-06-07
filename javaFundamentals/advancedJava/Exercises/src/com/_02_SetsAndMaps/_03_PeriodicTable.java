package com._02_SetsAndMaps;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> set = new TreeSet<>();

        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            for (String str : input) {
                set.add(str);
            }
        }

        for (String s : set) {
            System.out.printf("%s ",s);
        }
    }
}
