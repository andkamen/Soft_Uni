package bg.softuni.commands;

import bg.softuni.commands.contracts.Executable;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.contracts.DirectoryManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.contracts.Database;

public abstract class Command implements Executable {
    private String input;
    private String[] data;
    private Database repository;
    private Tester tester;
    private DirectoryManager ioManager;
    private DownloadManager downloadManager;

    protected Command(String input,
                      String[] data,
                      Tester tester,
                      Database repository,
                      DownloadManager downloadManager,
                      DirectoryManager ioManager) {
        this.setInput(input);
        this.setData(data);
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    protected Database getRepository() {
        return repository;
    }

    protected Tester getTester() {
        return tester;
    }

    protected DirectoryManager getIoManager() {
        return ioManager;
    }

    protected DownloadManager getDownloadManager() {
        return downloadManager;
    }

    protected String getInput() {
        return input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidInputException(this.input);
        }
        this.input = input;
    }

    protected String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidInputException(this.input);
        }
        this.data = data;
    }

    public abstract void execute() throws Exception;
}
