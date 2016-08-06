package bg.softuni.repository.contracts;

import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.models.contracts.Course;
import bg.softuni.models.contracts.Student;

import java.util.Comparator;

public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);

}
