package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class DropDatabaseCommand extends Command {
    public DropDatabaseCommand(String input,
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
        if (data.length != 1){
            throw new InvalidInputException(this.getInput());
        }

        this.getStudentRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
