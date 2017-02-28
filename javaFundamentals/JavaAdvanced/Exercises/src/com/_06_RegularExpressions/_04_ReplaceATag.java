package com._06_RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder output = new StringBuilder();

        while (!input.equals("end")) {

            output.append(input.replace("<a", "[URL").replace("</a>", "[/URL]"));

            input = reader.readLine();
        }
        System.out.println(output.toString());

    }
}
