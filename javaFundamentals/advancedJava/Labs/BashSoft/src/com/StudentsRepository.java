package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentsRepository {

    private static boolean isDataInitialized = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData() {
        if (isDataInitialized) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<>();
        readData();
    }

    private static void readData() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("")) {
            String[] tokens = input.split("\\s+");
            String course = tokens[0];
            String student = tokens[1];
            Integer mark = Integer.parseInt(tokens[2]);

            if (!studentsByCourse.containsKey(course)) {
                studentsByCourse.put(course, new HashMap<>());
            }
            if (!studentsByCourse.get(course).containsKey(student)) {
                studentsByCourse.get(course).put(student, new ArrayList<>());
            }
            studentsByCourse.get(course).get(student).add(mark);

            input = scan.nextLine();
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read");
    }

    private static boolean isQuearyForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        return true;
    }

    private static boolean isQuearyForStudenPossible(String courseName, String studentName) {
        if (!isQuearyForCoursePossible(courseName)) {
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }
        return true;
    }

    public static void getStudentMarksInCourse(String course, String student){
        if (!isQuearyForStudenPossible(course,student)){
            return;
        }
        ArrayList<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student,marks);
    }

    public static void getStudentByCourse(String course){
        if (!isQuearyForCoursePossible(course)){
            return;
        }

        OutputWriter.writeMessageOnNewLine(course+":");
        for (Map.Entry<String,ArrayList<Integer>> student : studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(student.getKey(),student.getValue());
        }
    }




}

