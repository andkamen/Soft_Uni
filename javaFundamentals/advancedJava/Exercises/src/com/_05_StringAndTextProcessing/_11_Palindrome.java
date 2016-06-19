package com._05_StringAndTextProcessing;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class _11_Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split("\\W+");
        //sort lexicographically
        Collator collator = Collator.getInstance(Locale.US);
        TreeSet<String> palindromes = new TreeSet<>(collator);

        for (String word : words) {
            boolean isPalindrome = checkIfPalindrome(word);
            if (isPalindrome) {
                palindromes.add(word);
            }
        }
        System.out.println(palindromes.toString());
    }

    private static boolean checkIfPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

