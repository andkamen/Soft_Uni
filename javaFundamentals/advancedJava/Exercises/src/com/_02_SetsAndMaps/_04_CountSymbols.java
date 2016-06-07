package com._02_SetsAndMaps;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<Character, Integer> symbolCount = new TreeMap<>();

        String input = scan.nextLine();

        for (char ch : input.toCharArray()) {
            if (!symbolCount.containsKey(ch)) {
                symbolCount.put(ch, 1);
            } else {
                int val = symbolCount.get(ch) + 1;
                symbolCount.put(ch, val);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolCount.entrySet()) {
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
