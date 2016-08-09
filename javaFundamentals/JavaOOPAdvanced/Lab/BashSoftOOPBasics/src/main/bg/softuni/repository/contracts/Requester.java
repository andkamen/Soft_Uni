package main.bg.softuni.repository.contracts;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.models.contracts.Course;
import main.bg.softuni.models.contracts.Student;

import java.util.Comparator;

public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);

}
