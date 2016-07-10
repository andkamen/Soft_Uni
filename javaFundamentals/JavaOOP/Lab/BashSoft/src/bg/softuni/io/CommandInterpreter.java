package bg.softuni.io;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.commands.*;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

import java.io.IOException;

public class CommandInterpreter {

    private Tester tester;
    private StudentRepository repository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(Tester tester,
                              StudentRepository repository,
                              DownloadManager downloadManager,
                              IOManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (IllegalArgumentException iae) {
            OutputWriter.displayException(iae.getMessage());
        } catch (StringIndexOutOfBoundsException sioobe) {
            OutputWriter.displayException(sioobe.getMessage());
        } catch (IOException ioe) {
            OutputWriter.displayException(ioe.getMessage());
        } catch (Throwable t) {
            OutputWriter.displayException(t.getMessage());
        }
    }

    private Command parseCommand(String input, String[] data, String command) throws IOException {
        switch (command) {
            case "open":
                return new OpenFileCommand(input, data, repository, tester, ioManager, downloadManager);

            case "mkdir":
                return new MakeDirectoryCommand(input, data, repository, tester, ioManager, downloadManager);

            case "ls":
                return new TraverseFoldersCommand(input, data, repository, tester, ioManager, downloadManager);

            case "cmp":
                return new CompareFilesCommand(input, data, repository, tester, ioManager, downloadManager);

            case "cdrel":
                return new ChangeRelativePathCommand(input, data, repository, tester, ioManager, downloadManager);

            case "cdabs":
                return new ChangeAbsolutePathCommand(input, data, repository, tester, ioManager, downloadManager);

            case "readdb":
                return new ReadDatabaseCommand(input, data, repository, tester, ioManager, downloadManager);

            case "help":
                return new GetHelpCommand(input, data, repository, tester, ioManager, downloadManager);

            case "show":
                return new ShowCourseCommand(input, data, repository, tester, ioManager, downloadManager);

            case "filter":
                return new PrintFilteredStudentsCommand(input, data, repository, tester, ioManager, downloadManager);

            case "order":
                return new PrintOrderedStudentsCommand(input, data, repository, tester, ioManager, downloadManager);

            case "download":
                return new DownloadFileCommand(input, data, repository, tester, ioManager, downloadManager);

            case "downloadasynch":
                return new DownloadAsynchCommand(input, data, repository, tester, ioManager, downloadManager);

            case "dropdb":
                return new DropDatabaseCommand(input, data, repository, tester, ioManager, downloadManager);

            default:
                throw new InvalidInputException(input);
        }
    }
}
