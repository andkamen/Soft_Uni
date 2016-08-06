package bg.softuni.commands;

import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.OutputWriter;
import bg.softuni.io.contracts.DirectoryManager;
import bg.softuni.judge.Tester;
import bg.softuni.models.contracts.Course;
import bg.softuni.models.contracts.Student;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.contracts.Database;

import java.util.Comparator;

public class DisplayCommand extends Command{

    public DisplayCommand(String input,
                          String[] data,
                          Tester tester,
                          Database repository,
                          DownloadManager downloadManager,
                          DirectoryManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3){
            throw new InvalidInputException(this.getInput());
        }

        String entryToDisplay = data[1];
        String sortType = data[2];

        if (entryToDisplay.equalsIgnoreCase("students")){
            Comparator<Student> studentComparator = this.createStudentComparator(sortType);
            SimpleSortedList<Student> sortedStudents = this.getRepository().getAllStudentsSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(sortedStudents.joinWith(System.lineSeparator()));

        } else if (entryToDisplay.equalsIgnoreCase("courses")){

            Comparator<Course> courseComparator = this.createCourseComparator(sortType);
            SimpleSortedList<Course> sortedCourses = this.getRepository().getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(sortedCourses.joinWith(System.lineSeparator()));

        } else {
            throw new InvalidInputException(this.getInput());
        }
    }

    private Comparator<Course> createCourseComparator(String sortType) {
        switch (sortType){
            case "ascending":
                return (o1, o2) -> o1.compareTo(o2);

            case "descending":
                return (o1, o2) -> o2.compareTo(o1);

            default:
                throw new InvalidInputException(this.getInput());
        }
    }


    private Comparator<Student> createStudentComparator(String sortType) {
        switch (sortType){
            case "ascending":
                return Comparable::compareTo;

            case "descending":
                return (o1, o2) -> o2.compareTo(o1);

            default:
                throw new InvalidInputException(this.getInput());
        }
    }
}
