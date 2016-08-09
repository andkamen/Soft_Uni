package com.core;

import com.commands.ChangeManagementRequirementCommand;
import com.commands.ProcessGarbageCommand;
import com.commands.StatusCommand;
import com.commands.contracts.Command;
import com.core.contracts.CommandDispatcher;
import com.core.contracts.RecyclingStation;
import com.core.contracts.WasteFactory;
import com.wasteDisposal.Contracts.GarbageProcessor;

public class CommandInterpreter implements CommandDispatcher {
    private RecyclingStation recyclingStation;
    private GarbageProcessor garbageProcessor;
    private WasteFactory wasteFactory;

    public CommandInterpreter() {
        this.recyclingStation = new RecyclingStationImpl();
        this.garbageProcessor = null;
    }

    public CommandInterpreter(GarbageProcessor garbageProcessor, WasteFactory wasteFactory) {
        this.recyclingStation = new RecyclingStationImpl();
        this.garbageProcessor = garbageProcessor;
        this.wasteFactory = wasteFactory;
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
    public WasteFactory getWasteFactory() {
        return this.wasteFactory;
    }

    @Override
    public Command dispatchCommand(String commandName, String[] arguments) {
        Command command = null;
        switch (commandName) {
            case "ProcessGarbage":
                command = new ProcessGarbageCommand(this.getRecyclingStation(), this.getGarbageProcessor(), this.getWasteFactory(), arguments);
                break;
            case "Status":
                command = new StatusCommand(this.getRecyclingStation());
                break;
            case "ChangeManagementRequirement":
                command = new ChangeManagementRequirementCommand(this.getRecyclingStation(), arguments);
                break;
            case "TimeToRecycle":
                break;
        }

        return command;
    }
}
