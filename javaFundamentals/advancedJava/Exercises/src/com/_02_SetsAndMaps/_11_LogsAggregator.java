package com._02_SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _11_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, TreeMap<String, Integer>> userData = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());


        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s");
            if (!userData.containsKey(input[1])) {
                userData.put(input[1], new TreeMap<>());
            }
            if (!userData.get(input[1]).containsKey(input[0])) {
                userData.get(input[1]).put(input[0], Integer.parseInt(input[2]));
            } else {

                int val = userData.get(input[1]).get(input[0]) + Integer.parseInt(input[2]);
                userData.get(input[1]).put(input[0], val);
            }
        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry : userData.entrySet()) {
            int duration =0;
            for (Integer dur : entry.getValue().values()) {
                duration+=dur;
            }
            System.out.printf("%s: %d [",entry.getKey(),duration);
            System.out.print(String.join(", ",entry.getValue().keySet()));
            System.out.print("]");
            System.out.println();

        }
    }
}
