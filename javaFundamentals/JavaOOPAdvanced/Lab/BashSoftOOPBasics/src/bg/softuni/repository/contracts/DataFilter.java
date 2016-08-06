package bg.softuni.repository.contracts;

import java.util.HashMap;

public interface DataFilter {

    void printFilteredStudents(
            HashMap<String, Double> studentsWithMarks,
            String filterType,
            Integer numberOfStudents);

}
