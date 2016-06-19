package com._08_StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_StudentsByFirstAndLastName {
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
                .filter(s -> s[0].compareTo(s[1])<0)
                .forEach(s -> System.out.printf("%s %s%n", s[0], s[1]));
    }
}
