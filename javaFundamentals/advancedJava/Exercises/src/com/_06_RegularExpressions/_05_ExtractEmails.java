package com._06_RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?<user>[\\.\\-\\w]+)@(?<host>\\w+\\.\\w+)(\\.\\w+)?");

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
