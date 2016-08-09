package bg.softuni.interfaces;

public interface CommandDispatcher {
    PowerPlant getNuclearPowerPlant();

    Command dispatchCommand(String commandName, String[] arguments);
}
