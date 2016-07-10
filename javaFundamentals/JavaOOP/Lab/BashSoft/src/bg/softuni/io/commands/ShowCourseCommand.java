package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class ShowCourseCommand extends Command {
    public ShowCourseCommand(String input,
                                   String[] data,
                                   StudentRepository studentRepository,
                                   Tester tester,
                                   IOManager ioManager,
                                   DownloadManager downloadManager) {
        super(input, data, studentRepository, tester, ioManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2 && data.length != 3){
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2){
            String courseName = data[1];
            this.getStudentRepository().getStudentsByCourse(courseName);
        } else {
            String courseName = data[1];
            String student = data[2];
            this.getStudentRepository().getStudentMarkInCourse(courseName, student);
        }
    }
}
