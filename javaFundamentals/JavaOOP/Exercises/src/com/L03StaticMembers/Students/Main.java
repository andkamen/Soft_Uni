package com.L03StaticMembers.Students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String input = scan.nextLine();
            if (input.equals("End")){
                break;
            }

            Student student = new Student(input);
        }

        System.out.println(Student.getStudentCount());
    }
}
