package com._05_StringAndTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _01_ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder output = new StringBuilder();
        for (int i = input.length()-1; i >=0 ; i--) {
            output.append(input.charAt(i));
        }
        System.out.println(output);
    }
}
