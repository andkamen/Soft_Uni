package core.contracts;

import commands.contracts.Command;
import wasteDisposal.Contracts.GarbageProcessor;

public interface CommandDispatcher {

    RecyclingStation getRecyclingStation();

    GarbageProcessor getGarbageProcessor();

    Command dispatchCommand(String commandName, String[] arguments);

}
