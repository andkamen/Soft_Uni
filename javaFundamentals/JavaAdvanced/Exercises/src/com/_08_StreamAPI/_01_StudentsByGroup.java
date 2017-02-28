package com._08_StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_StudentsByGroup {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String[]> studentsData = new ArrayList<>();

        while (true) {
            String line = scan.nextLine();
            if (line.equals("END")) {
                break;
            }
            studentsData.add(line.split("\\s+"));
        }

        studentsData.stream()
                .filter(s -> s[2].equals("2"))
                .sorted((s1, s2) -> s1[0].compareTo(s2[0]))
                .forEach(s -> System.out.printf("%s %s%n", s[0], s[1]));
    }
}
