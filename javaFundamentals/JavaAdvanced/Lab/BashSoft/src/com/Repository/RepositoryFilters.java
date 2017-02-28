package com.Repository;

import com.StaticData.ExceptionMessages;
import com.IO.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class RepositoryFilters {
    public static void printFilteredStudents(HashMap<String, ArrayList<Integer>> courseData, String filterType, int numberOfStudents) {
        Predicate<Double> predicate = createFilter(filterType);
        filterAndTake(predicate, courseData, numberOfStudents);
    }

    private static void filterAndTake(Predicate<Double> filter, HashMap<String, ArrayList<Integer>> courseData, int numberOfStudents) {
        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsCount = 0;
        for (String student : courseData.keySet()) {
            if (studentsCount == numberOfStudents) {
                break;
            }
            List<Integer> studentMarks = courseData.get(student);
            double averageMark = studentMarks.stream().mapToInt(Integer::valueOf).average().getAsDouble();
            double mark = (averageMark / 100) * 4 + 2;
            if (filter.test(mark)) {
                OutputWriter.printStudent(student, studentMarks);
                studentsCount++;
            }
        }
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;

            case "average":
                return mark -> mark >= 3.50 && mark < 5.0;

            case "poor":
                return mark -> mark < 3.5;

            default:
                return null;
        }
    }
}
