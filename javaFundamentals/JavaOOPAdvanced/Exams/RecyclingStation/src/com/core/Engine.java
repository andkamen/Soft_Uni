package com.core;

import com.commands.contracts.Command;
import com.core.contracts.CommandDispatcher;
import com.core.contracts.EngineInterface;
import com.core.contracts.WasteFactory;
import com.io.ConsoleReader;
import com.io.ConsoleWriter;
import com.io.contracts.InputReader;
import com.io.contracts.OutputWriter;
import com.utilities.Constants;
import com.wasteDisposal.Annotations.Burnable;
import com.wasteDisposal.Annotations.Recyclable;
import com.wasteDisposal.Annotations.Storable;
import com.wasteDisposal.Contracts.GarbageProcessor;
import com.wasteDisposal.Contracts.StrategyHolder;
import com.wasteDisposal.DefaultGarbageProcessor;
import com.wasteDisposal.DefaultStrategyHolder;
import com.wasteDisposal.Strategies.BurnableStrategy;
import com.wasteDisposal.Strategies.RecyclableStrategy;
import com.wasteDisposal.Strategies.StorableStrategy;

import java.util.Arrays;
import java.util.List;

public class Engine implements EngineInterface {

    private InputReader consoleReader;
    private OutputWriter consoleWriter;
    private StrategyHolder strategyHolder;
    private GarbageProcessor garbageProcessor;
    private CommandDispatcher commandInterpreter;
    private WasteFactory wasteFactory;
    private Boolean isRunning;

    public Engine() {
        this.consoleReader = new ConsoleReader();
        this.consoleWriter = new ConsoleWriter();
        this.strategyHolder = new DefaultStrategyHolder();
        this.garbageProcessor = new DefaultGarbageProcessor();
        this.wasteFactory = new WasteFactoryImpl();
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
    }

    private void processInput(String input) {
        String[] splitArgs = input.split(Constants.INPUT_SPLIT_DELIMITER);

        String commandName = splitArgs[0];

        if (commandName.equals(Constants.INPUT_TERMINATING_COMMAND)) {
            this.isRunning = false;
            return;
        }
        String[] filteredArgs = null;

        if (splitArgs.length > 1) {
            List<String> commandArgs = Arrays.asList(splitArgs[1].split(Constants.INPUT_COMMAND_ARGUMENTS_SPLIT_DELIMITER));
            filteredArgs = commandArgs.stream().filter(e -> e.length() >= 1).toArray(String[]::new);
        }
        try {
            Command command = commandInterpreter.dispatchCommand(commandName, filteredArgs);

            if (command == null) {

                return;
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
        this.commandInterpreter = new CommandInterpreter(this.garbageProcessor, this.wasteFactory);
    }
}
