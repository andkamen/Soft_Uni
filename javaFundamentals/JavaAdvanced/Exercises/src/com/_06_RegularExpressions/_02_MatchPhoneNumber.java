package com._06_RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!input.equals("end")) {
            Pattern pattern = Pattern.compile("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }
}
