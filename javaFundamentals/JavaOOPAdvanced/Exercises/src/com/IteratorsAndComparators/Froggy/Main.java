package com.IteratorsAndComparators.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("[\\s,]+")).map(Integer::parseInt).collect(Collectors.toList());
        reader.readLine();

        Lake<Integer> lake = new Lake<>(numbers);

        StringBuilder output = new StringBuilder();
        for (Integer integer : lake) {
            output.append(String.format("%d, ", integer));
        }
        output.setLength(output.length() - 2);

        System.out.println(output.toString());
    }
}
