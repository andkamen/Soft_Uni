package bg.softuni.models.contracts;


import java.util.Comparator;
import java.util.Map;

public interface Student extends Comparable<Student> {

    String getUserName();

    Map<String, Double> getMarksByCourseName();

    void enrollInCourse(Course course);

    void setMarkOnCourse(String courseName, int... scores);

    String getMarkForCourse(String courseName);

    Map<String, Course> getEnrolledCourses();

}
