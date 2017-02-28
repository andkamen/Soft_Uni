package com._05_StringAndTextProcessing;

import java.util.Scanner;

public class _12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split(" ");

        int longerStrNum = (data[0].length() > data[1].length()) ? 0 : 1;
        int shorterStrNum = (data[0].length() > data[1].length()) ? 1 : 0;

        int totalSum = 0;
        for (int i = 0; i < data[shorterStrNum].length(); i++) {
            totalSum += data[0].charAt(i) * data[1].charAt(i);
        }

        for (int i = data[shorterStrNum].length(); i < data[longerStrNum].length(); i++) {
            totalSum += data[longerStrNum].charAt(i);
        }
        System.out.println(totalSum);

    }
}
