package com.IteratorsAndComparators.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator iterator = null;

        while (true) {
            String[] params = reader.readLine().split("\\s+");
            if (params[0].equals("END")) {
                break;
            }

            try {
                switch (params[0]) {
                    case "Create":
                        List<String> list = Arrays.asList(params).stream().skip(1).collect(Collectors.toList());
                        iterator = new ListyIterator<>(list);
                        break;
                    case "Move":
                        System.out.println(iterator.move());
                        break;
                    case "Print":
                        iterator.print();
                        break;
                    case "HasNext":
                        System.out.println(iterator.hasNext());
                        break;
                    case "PrintAll":
                        iterator.printAll();
                        break;
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
