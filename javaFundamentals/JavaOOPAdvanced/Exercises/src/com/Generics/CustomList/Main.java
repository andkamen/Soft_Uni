package com.Generics.CustomList;

import com.Generics.CustomList.models.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandParser parser = new CommandParser();

        while (true) {
            String[] input = reader.readLine().split("\\s+");

            try {
                parser.execute(input);
            } catch (IllegalArgumentException | IllegalStateException iae) {
                System.out.println(iae.getMessage());
            }
            if (input[0].equals("END")) {
                break;
            }
        }


    }
}
