package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;
import bg.softuni.staticData.ExceptionMessages;

public class PrintFilteredStudentsCommand extends Command {
    public PrintFilteredStudentsCommand(String input,
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
        if (data.length != 5) {
            throw new InvalidInputException(this.getInput());
        }

        String course = data[1];
        String filter = data[2].toLowerCase();
        String takeCommand = data[3].toLowerCase();
        String takeQuantity = data[4].toLowerCase();

        this.tryParseParametersForFilter(takeCommand, takeQuantity, course, filter);
    }

    private void tryParseParametersForFilter(
            String takeCommand, String takeQuantity,
            String courseName, String filter) {
        if (!takeCommand.equals("take")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TAKE_COMMAND);
        }

        if (takeQuantity.equals("all")) {
            this.getStudentRepository().filterAndTake(courseName, filter);
            return;
        }

        try {
            int studentsToTake = Integer.parseInt(takeQuantity);
            this.getStudentRepository().filterAndTake(courseName, filter, studentsToTake);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TAKE_QUANTITY_PARAMETER);
        }
    }
}