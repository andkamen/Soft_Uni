package com.Generics.SwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box> elements = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(input);
            elements.add(box);
        }
        int[] elementsToSwap = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        swapElements(elements, elementsToSwap[0], elementsToSwap[1]);

        for (Box element : elements) {
            System.out.println(element);
        }

    }

    private static <T> void swapElements(List<T> elements, int n, int m) {
        T temp = elements.get(n);
        elements.set(n, elements.get(m));
        elements.set(m, temp);
    }

}
