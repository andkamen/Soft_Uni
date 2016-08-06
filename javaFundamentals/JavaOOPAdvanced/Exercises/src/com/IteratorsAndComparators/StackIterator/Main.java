package com.IteratorsAndComparators.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackIterator<Integer> data = new StackIterator<>();

        while (true) {
            String[] params = reader.readLine().split("[\\s,]+");
            if (params[0].equals("END")) {
                break;
            }

            try {
                switch (params[0]) {
                    case "Push":
                        for (int i = 1; i < params.length; i++) {
                            data.push(Integer.parseInt(params[i]));
                        }
                        break;
                    case "Pop":
                        data.pop();
                        break;
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Integer integer : data) {
            System.out.println(integer);
        }

        for (Integer integer : data) {
            System.out.println(integer);
        }
    }
}
