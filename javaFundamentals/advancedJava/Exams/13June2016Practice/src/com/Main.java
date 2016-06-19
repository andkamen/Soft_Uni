package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> masters = new ArrayDeque<>();
        Queue<String> knights = new ArrayDeque<>();
        Queue<String> padawans = new ArrayDeque<>();
        Queue<String> smartasses = new ArrayDeque<>();
        boolean hasFoundYoda = false;

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            for (String s : input) {

                char ch = s.charAt(0);
                switch (ch) {
                    case 'm':
                        masters.add(s);
                        break;
                    case 'k':
                        knights.add(s);
                        break;
                    case 'p':
                        padawans.add(s);
                        break;
                    case 's':
                        smartasses.add(s);
                        break;
                    case 't':
                        smartasses.add(s);
                        break;
                    case 'y':
                        hasFoundYoda=true;
                        break;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        if (!hasFoundYoda){
            output.append(String.join(" ",smartasses)+" ");
            output.append(String.join(" ",masters)+ " ");
            output.append(String.join(" ",knights)+ " ");
            output.append(String.join(" ",padawans));
        }
        else {
            output.append(String.join(" ",masters)+ " ");
            output.append(String.join(" ",knights)+ " ");
            output.append(String.join(" ",smartasses)+" ");
            output.append(String.join(" ",padawans));
        }


        System.out.println(output.toString());

    }
}
