package com._05_StringAndTextProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _15_MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = new String(scan.nextLine());
        String removePattern = scan.nextLine();
        String message = "Shaked it.";
        //String strPattern = String.format("(%s)",initialPattern);


        StringBuilder escapeRemovePattern = new StringBuilder();
        for (char c : removePattern.toCharArray()) {
            if (c == ')') {
                escapeRemovePattern.append("\\)");
            } else if (c == '(') {
                escapeRemovePattern.append("\\)");
            } else {
                escapeRemovePattern.append(c);
            }
        }
        removePattern = escapeRemovePattern.toString();

        while (message == "Shaked it.") {

            Pattern pattern = Pattern.compile(removePattern);
            Matcher matcher = pattern.matcher(input);

            int count = 0;
            while (matcher.find()) {
                count++;
            }
            if (count < 2 || removePattern.length() <= 0) {
                message = "No shake.";
                System.out.println(message);
                break;
            }
            input = replaceLast(input, removePattern, "");
            input = input.replaceFirst(removePattern, "");

            StringBuilder nextPattern = new StringBuilder(removePattern);
            if (nextPattern.charAt(nextPattern.length() / 2) == ')') {
                nextPattern.delete((nextPattern.length() / 2) - 1, nextPattern.length() / 2);
            } else if (nextPattern.charAt(nextPattern.length() / 2) == '(') {
                nextPattern.delete((nextPattern.length() / 2) - 1, nextPattern.length() / 2);
            } else if (nextPattern.charAt(nextPattern.length() / 2) == '/') {
                nextPattern.delete((nextPattern.length() / 2), nextPattern.length() / 2 + 1);
            } else {
                nextPattern.deleteCharAt(nextPattern.length() / 2);
            }

            removePattern = nextPattern.toString();
            System.out.println(message);
        }
        System.out.println(input);
    }

    public static String replaceLast(String string, String toReplace, String replacement) {
        int pos = string.lastIndexOf(toReplace);
        if (pos > -1) {
            return string.substring(0, pos)
                    + replacement
                    + string.substring(pos + toReplace.length(), string.length());
        } else {
            return string;
        }
    }
}
