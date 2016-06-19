package com.Repository;

import com.StaticData.ExceptionMessages;
import com.IO.OutputWriter;
import com.StaticData.SessionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentRepository {
    private static boolean isDataInitialized = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(String fileName) {
        if (isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new LinkedHashMap<>();
        try {
            readData(fileName);
            isDataInitialized = true;
        } catch (IOException e) {
            OutputWriter.displayException(ExceptionMessages.FILE_NOT_FOUND);
        }
    }

    private static void readData(String fileName) throws IOException {
        String regex = "([A-Z][a-zA-Z+#]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String path = SessionData.currentPath + "\\resources\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (line.isEmpty() || !matcher.find()) {
                continue;
            }

            String course = matcher.group(1);
            String student = matcher.group(2);
            Integer mark = Integer.parseInt(matcher.group(3));
            if (mark >= 0 && mark <= 100) {
                if (!studentsByCourse.containsKey(course)) {
                    studentsByCourse.put(course, new LinkedHashMap<>());
                }
                if (!studentsByCourse.get(course).containsKey(student)) {
                    studentsByCourse.get(course).put(student, new ArrayList<>());
                }
                studentsByCourse.get(course).get(student).add(mark);
            }
        }

        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        return true;
    }

    private static boolean isQueryForStudentPossible(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)) {
            OutputWriter.writeMessageOnNewLine(ExceptionMessages.NON_EXISTENT_STUDENT);
            return false;
        }
        return true;
    }

    public static void getStudentMarksInCourse(String course, String student) {
        if (!isQueryForStudentPossible(course, student)) {
            return;
        }
        ArrayList<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student, marks);
    }

    public static void getStudentByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, ArrayList<Integer>> student : studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }

    public static void printOrderedStudents(String course, String comparisonType, Integer numberOfStudents) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        if (numberOfStudents == null) {
            numberOfStudents = studentsByCourse.get(course).size();
        }

        RepositorySorters.printSortedStudents(studentsByCourse.get(course), comparisonType, numberOfStudents);
    }

    public static void printFilteredStudents(String course, String filter, Integer numberOfStudents) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        if (numberOfStudents == null) {
            numberOfStudents = studentsByCourse.get(course).size();
        }
        RepositoryFilters.printFilteredStudents(studentsByCourse.get(course), filter, numberOfStudents);
    }
}

