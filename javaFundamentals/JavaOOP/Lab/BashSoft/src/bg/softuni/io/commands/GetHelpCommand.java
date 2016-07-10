package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class GetHelpCommand extends Command {
    public GetHelpCommand(String input,
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
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }

        displayHelp();
    }
    private void displayHelp() {
        String helpBuilder = "make directory - mkdir nameOfFolder" +
                System.lineSeparator() +
                "traverse directory - ls depth" +
                System.lineSeparator() +
                "comparing files - cmp absolutePath1 absolutePath2" +
                System.lineSeparator() +
                "change directory - cdRel relativePath or \"..\" for level up" +
                System.lineSeparator() +
                "change directory - cdAbs absolutePath" +
                System.lineSeparator() +
                "read students data base - readDb fileName" +
                System.lineSeparator() +
                "filter students - filter {courseName} excellent/average/poor take 2/5/all" +
                System.lineSeparator() +
                "order students - order {courseName} ascending/descending take 20/10/all" +
                System.lineSeparator() +
                "download file - download URL (saved in current directory)" +
                System.lineSeparator() +
                "download file on new thread - downloadAsynch URL (saved in the current directory)" +
                System.lineSeparator() +
                "get help – help" +
                System.lineSeparator();

        OutputWriter.writeMessage(helpBuilder);
        OutputWriter.writeEmptyLine();
    }
}
