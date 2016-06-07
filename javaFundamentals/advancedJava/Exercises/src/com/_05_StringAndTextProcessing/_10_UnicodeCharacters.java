package com._05_StringAndTextProcessing;

import java.util.Scanner;

public class _10_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        for (char ch : input.toCharArray()) {
            System.out.print( "\\u" + Integer.toHexString(ch | 0x10000).substring(1) );
        }
    }
}
