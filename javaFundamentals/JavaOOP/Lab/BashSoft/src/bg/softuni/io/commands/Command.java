package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public abstract class Command {
    private String input;
    private String[] data;
    private StudentRepository studentRepository;
    private Tester tester;
    private IOManager ioManager;
    private DownloadManager downloadManager;

    Command(String input,
            String[] data,
            StudentRepository studentRepository,
            Tester tester,
            IOManager ioManager,
            DownloadManager downloadManager) {
        this.setInput(input);
        this.setData(data);
        this.studentRepository = studentRepository;
        this.tester = tester;
        this.ioManager = ioManager;
        this.downloadManager = downloadManager;
    }

    StudentRepository getStudentRepository() {
        return studentRepository;
    }

    Tester getTester() {
        return tester;
    }

    IOManager getIoManager() {
        return ioManager;
    }

    DownloadManager getDownloadManager() {
        return downloadManager;
    }

    String getInput() {
        return input;
    }

    private void setInput(String input) {
        if (input == null || input.trim().length() == 0) {
            throw new InvalidInputException(input);
        }
        this.input = input;
    }

    String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidInputException(this.getInput());
        }
        this.data = data;
    }

    public abstract void execute() throws Exception;
}
