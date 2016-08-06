package bg.softuni.models.contracts;

import java.util.Map;

public interface Course extends Comparable<Course>{

    int NUMBER_OF_TASKS_ON_EXAM = 5;
    int MAX_SCORE_ON_EXAM_TASK = 100;

    String getName();

    Map<String, Student> getStudentsByName();

    void enrollStudent(Student student);

}
