package com.L03StaticMembers.UniqueStudentNames;

import java.util.Scanner;

import static com.L03StaticMembers.UniqueStudentNames.StudentGroup.addStudent;
import static com.L03StaticMembers.UniqueStudentNames.StudentGroup.getUniqueStudentsCount;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            Student student = new Student(input);
            addStudent(student);
        }

        System.out.println(getUniqueStudentsCount());
    }
}
