package bg.softuni.io.commands;


import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class TraverseFoldersCommand extends Command {
    public TraverseFoldersCommand(String input,
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
        if (data.length != 1 && data.length != 2){
            throw new InvalidInputException(this.getInput());
        }
        String result;

        if (data.length == 1){
           this.getIoManager().traverseDirectory(0);
        } else {
            int depth = Integer.parseInt(data[1]);
            this.getIoManager().traverseDirectory(depth);
        }
    }
}