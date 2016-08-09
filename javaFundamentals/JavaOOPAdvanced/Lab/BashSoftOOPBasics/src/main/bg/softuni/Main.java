package main.bg.softuni;

import main.bg.softuni.io.contracts.Interpreter;
import main.bg.softuni.io.CommandInterpreter;
import main.bg.softuni.io.IOManager;
import main.bg.softuni.io.InputReader;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.judge.Tester;
import main.bg.softuni.network.DownloadManager;
import main.bg.softuni.repository.RepositoryFilter;
import main.bg.softuni.repository.RepositorySorter;
import main.bg.softuni.repository.StudentsRepository;
import main.bg.softuni.repository.contracts.Database;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter sorter = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        Database repository = new StudentsRepository(filter, sorter);
        Interpreter currentInterpreter = new CommandInterpreter(
                tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}