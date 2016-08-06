package com.Generics.CountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> elements = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(reader.readLine());
            elements.add(input);
        }

        Double compareStr = Double.parseDouble(reader.readLine());

        System.out.println(countGreater(elements, compareStr));
    }

    private static <T extends Comparable<T>> int countGreater(List<T> elements, T compareStr) {
        int count = 0;

        for (T element : elements) {
            if (element.compareTo(compareStr) > 0) {
                count++;
            }
        }

        return count;
    }
}
