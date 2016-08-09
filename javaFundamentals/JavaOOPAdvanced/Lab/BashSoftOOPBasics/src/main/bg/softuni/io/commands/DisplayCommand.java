package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.models.contracts.Course;
import main.bg.softuni.models.contracts.Student;
import main.bg.softuni.repository.contracts.Database;

import java.util.Comparator;

@Alias(value = "display")
public class DisplayCommand extends Command {

    @Inject
    private Database repository;

    public DisplayCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String entryToDisplay = data[1];
        String sortType = data[2];

        if (entryToDisplay.equalsIgnoreCase("students")) {
            Comparator<Student> studentComparator = this.createStudentComparator(sortType);
            SimpleSortedList<Student> sortedStudents = this.repository.getAllStudentsSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(sortedStudents.joinWith(System.lineSeparator()));

        } else if (entryToDisplay.equalsIgnoreCase("courses")) {

            Comparator<Course> courseComparator = this.createCourseComparator(sortType);
            SimpleSortedList<Course> sortedCourses = this.repository.getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(sortedCourses.joinWith(System.lineSeparator()));

        } else {
            throw new InvalidInputException(this.getInput());
        }
    }

    private Comparator<Course> createCourseComparator(String sortType) {
        switch (sortType) {
            case "ascending":
                return (o1, o2) -> o1.compareTo(o2);

            case "descending":
                return (o1, o2) -> o2.compareTo(o1);

            default:
                throw new InvalidInputException(this.getInput());
        }
    }


    private Comparator<Student> createStudentComparator(String sortType) {
        switch (sortType) {
            case "ascending":
                return Comparable::compareTo;

            case "descending":
                return (o1, o2) -> o2.compareTo(o1);

            default:
                throw new InvalidInputException(this.getInput());
        }
    }
}
