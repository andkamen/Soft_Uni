package com._05_StringAndTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder(reader.readLine());
        output.setLength(20);
        System.out.println(output.toString().replaceAll("\0","*"));
    }
}
