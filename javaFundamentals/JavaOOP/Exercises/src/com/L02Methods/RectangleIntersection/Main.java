package com.L02Methods.RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Rectangle> rectangles = new HashMap<>();

        int[] params = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < params[0] ; i++) {
            String[] input = reader.readLine().split("\\s+");
            double width = Double.valueOf(input[1]);
            double height = Double.valueOf(input[2]);
            double leftX = Double.valueOf(input[3]);
            double leftY = Double.valueOf(input[4]);
            rectangles.put(input[0],new Rectangle(input[0],width,height,leftX,leftY));
        }

        for (int i = 0; i < params[1]; i++) {
            String[] input = reader.readLine().split("\\s+");

            System.out.println(rectangles.get(input[0]).intersects(rectangles.get(input[1])));
        }
    }
}