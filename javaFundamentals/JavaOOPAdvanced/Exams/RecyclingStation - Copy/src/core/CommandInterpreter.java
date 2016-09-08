package core;

import commands.ProcessGarbageCommand;
import commands.StatusCommand;
import commands.contracts.Command;
import core.contracts.CommandDispatcher;
import core.contracts.RecyclingStation;
import wasteDisposal.Contracts.GarbageProcessor;

public class CommandInterpreter implements CommandDispatcher {
    private RecyclingStation recyclingStation;
    private GarbageProcessor garbageProcessor;

    public CommandInterpreter() {
        this.recyclingStation = new RecyclingStationImpl();
        this.garbageProcessor = null;
    }

    public CommandInterpreter(GarbageProcessor garbageProcessor) {
        this.recyclingStation = new RecyclingStationImpl();
        this.garbageProcessor = garbageProcessor;
    }


    @Override
    public RecyclingStation getRecyclingStation() {
        return this.recyclingStation;
    }

    @Override
    public GarbageProcessor getGarbageProcessor() {
        return this.garbageProcessor;
    }

    @Override
    public Command dispatchCommand(String commandName, String[] arguments) {
        Command command = null;
        switch (commandName){
            case "ProcessGarbage":
                command = new ProcessGarbageCommand(this.getRecyclingStation(),this.getGarbageProcessor(),arguments);
                break;
            case "Status":
               command = new StatusCommand(this.getRecyclingStation());
                break;
            case "TimeToRecycle":
                break;
        }

        return command;
    }
}
