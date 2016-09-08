package com.core.contracts;

import com.commands.contracts.Command;
import com.wasteDisposal.Contracts.GarbageProcessor;

public interface CommandDispatcher {

    RecyclingStation getRecyclingStation();

    GarbageProcessor getGarbageProcessor();

    WasteFactory getWasteFactory();

    Command dispatchCommand(String commandName, String[] arguments);

}
