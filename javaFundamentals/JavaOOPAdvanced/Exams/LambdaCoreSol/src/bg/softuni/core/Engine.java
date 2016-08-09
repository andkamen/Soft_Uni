package bg.softuni.core;

import bg.softuni.interfaces.*;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;
import bg.softuni.utilities.Constants;

import java.util.Arrays;
import java.util.List;

public class Engine implements EngineInterface {

    private InputReader consoleReader;

    private OutputWriter consoleWriter;

    private CommandDispatcher commandInterpreter;

    private Boolean isRunning;

    public Engine() {
        this.consoleReader = new ConsoleReader();
        this.consoleWriter = new ConsoleWriter();
        this.commandInterpreter = new CommandInterpreter();
    }

    public void run() {
        this.isRunning = true;

        while (this.isRunning) {

            String inputLine = this.consoleReader.readLine();

            this.processInput(inputLine);
        }
    }

    private void processInput(String input) {
        String[] splittedArgs = input.split(Constants.INPUT_SPLIT_DELIMETER);

        String commandName = splittedArgs[0];

        if(commandName.equals(Constants.INPUT_TERMINATING_COMMAND)) {
            this.isRunning = false;
            return;
        }

        String[] filteredArgs = null;

        if(splittedArgs.length > 1) {
            List<String> commandArgs = Arrays.asList(splittedArgs[1].split(Constants.INPUT_COMMAND_ARGUMENTS_SPLIT_DELIMETER));
            filteredArgs = commandArgs.stream().filter(e -> e.length() >= 1).toArray(size -> new String[size]);
        }

        try {
            Command command = commandInterpreter.dispatchCommand(commandName, filteredArgs);

            if(command == null) {
                throw new NullPointerException("Invalid Command!");
            }

            String commandResult = command.execute();
            this.consoleWriter.writeLine(commandResult);
        } catch (Exception e) {
            this.consoleWriter.writeLine(e.getMessage());
        }
    }
}
