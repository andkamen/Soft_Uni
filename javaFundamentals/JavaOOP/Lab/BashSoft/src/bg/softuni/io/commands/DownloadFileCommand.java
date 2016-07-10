package bg.softuni.io.commands;

import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class DownloadFileCommand extends Command {
    public DownloadFileCommand(String input,
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
        if (data.length != 2){
            throw new IllegalArgumentException(this.getInput());
        }
        String fileUrl = data[1];
        this.getDownloadManager().download(fileUrl);
    }
}
