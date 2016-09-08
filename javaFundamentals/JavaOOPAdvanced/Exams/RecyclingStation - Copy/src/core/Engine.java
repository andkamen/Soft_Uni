package core;

import commands.contracts.Command;
import core.contracts.CommandDispatcher;
import core.contracts.EngineInterface;
import core.contracts.RecyclingStation;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.contracts.InputReader;
import io.contracts.OutputWriter;
import utilities.Constants;
import wasteDisposal.Annotations.Burnable;
import wasteDisposal.Annotations.Recyclable;
import wasteDisposal.Annotations.Storable;
import wasteDisposal.Contracts.GarbageProcessor;
import wasteDisposal.Contracts.StrategyHolder;
import wasteDisposal.DefaultGarbageProcessor;
import wasteDisposal.DefaultStrategyHolder;
import wasteDisposal.Strategies.BurnableStrategy;
import wasteDisposal.Strategies.RecyclableStrategy;
import wasteDisposal.Strategies.StorableStrategy;

import java.util.Arrays;
import java.util.List;

public class Engine implements EngineInterface {

    private InputReader consoleReader;
    private OutputWriter consoleWriter;
    private StrategyHolder strategyHolder;
    private GarbageProcessor garbageProcessor;
    private CommandDispatcher commandInterpreter;
    private Boolean isRunning;

    public Engine() {
        this.consoleReader = new ConsoleReader();
        this.consoleWriter = new ConsoleWriter();
        this.strategyHolder = new DefaultStrategyHolder();
        this.garbageProcessor = new DefaultGarbageProcessor();
        this.commandInterpreter = new CommandInterpreter();
    }

    @Override
    public void run() {
        this.isRunning = true;
        initialiseStrategyHolder();

        while (this.isRunning) {

            String inputLine = this.consoleReader.readLine();

            this.processInput(inputLine);
        }

        //System.out.println("loaded strategies");
//        Garbage recyclable = new RecyclableGarbage("Glass",10,1.14);
//        ProcessingData data = garbageProcessor.processWaste(recyclable);
//        System.out.println();


    }

    private void processInput(String input) {
        String[] splitArgs = input.split(Constants.INPUT_SPLIT_DELIMETER);

        String commandName = splitArgs[0];

        if (commandName.equals(Constants.INPUT_TERMINATING_COMMAND)) {
            this.isRunning = false;
            return;
        }
        String[] filteredArgs = null;

        if (splitArgs.length > 1) {
            List<String> commandArgs = Arrays.asList(splitArgs[1].split(Constants.INPUT_COMMAND_ARGUMENTS_SPLIT_DELIMETER));
            filteredArgs = commandArgs.stream().filter(e -> e.length() >= 1).toArray(String[]::new);
        }
        try {
            Command command = commandInterpreter.dispatchCommand(commandName, filteredArgs);

            if (command == null) {
                throw new NullPointerException("Invalid Command!");
            }

            String commandResult = command.execute();
            this.consoleWriter.writeLine(commandResult);
        } catch (Exception e) {
            this.consoleWriter.writeLine(e.getMessage());
        }


    }


    private void initialiseStrategyHolder() {
        this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());
        this.strategyHolder.addStrategy(Recyclable.class, new RecyclableStrategy());
        this.strategyHolder.addStrategy(Storable.class, new StorableStrategy());

        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolder);
        this.commandInterpreter = new CommandInterpreter(this.garbageProcessor);
    }
}
