package com._05_StringAndTextProcessing;

import java.util.Scanner;

public class _09_TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] bannedWords = scan.nextLine().split(", ");

        String text = scan.nextLine();

        for (String bannedWord : bannedWords) {

            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < bannedWord.length(); i++) {
                padding.append("*");
            }

            text = text.replaceAll(bannedWord,padding.toString());
        }
        System.out.println(text);

    }
}
