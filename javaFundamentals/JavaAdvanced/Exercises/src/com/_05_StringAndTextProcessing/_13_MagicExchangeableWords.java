package com._05_StringAndTextProcessing;

import java.util.HashMap;
import java.util.Scanner;

public class _13_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split(" ");

        HashMap<Character, Character> correspondingChar = new HashMap<>();
        //use math max to replace that ↓
        String longer = data[(data[0].length() > data[1].length()) ? 0 : 1];
        String shorter = data[(data[0].length() > data[1].length()) ? 1 : 0];

        for (int i = 0; i < shorter.length(); i++) {
            if (!correspondingChar.containsKey(shorter.charAt(i))){
                if (correspondingChar.containsValue(longer.charAt(i))){
                    System.out.println("false");
                    return;
                }
                correspondingChar.put(shorter.charAt(i),longer.charAt(i));
            }

            if (!correspondingChar.get(shorter.charAt(i)).equals(longer.charAt(i))){
                System.out.println("false");
                return;
            }
        }

        for (int i = shorter.length(); i < longer.length(); i++){
            if (!correspondingChar.containsValue(longer.charAt(i))){
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");

    }
}
