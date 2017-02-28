package com._06_RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_SentenceExtractor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("[^!.?]*\\b"+ word+"\\b[^!.?]*[!.?]");
        List<String> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        matches.forEach(System.out::println);
    }
}
