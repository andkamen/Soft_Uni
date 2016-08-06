package bg.softuni.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.contracts.DirectoryManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.contracts.Database;

public class ReadDatabaseCommand extends Command {

    public ReadDatabaseCommand(String input,
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
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileName = data[1];
        this.getRepository().loadData(fileName);
    }
}
