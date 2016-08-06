package bg.softuni.repository.contracts;

import java.util.HashMap;

public interface DataSorter {

    public void printSortedStudents(
            HashMap<String, Double> courseData,
            String comparisonType,
            int numberOfStudents);

}
