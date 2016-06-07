package com._02_SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }
        firstSet.retainAll(secondSet);
        String output = firstSet.stream().map(Object::toString).collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
