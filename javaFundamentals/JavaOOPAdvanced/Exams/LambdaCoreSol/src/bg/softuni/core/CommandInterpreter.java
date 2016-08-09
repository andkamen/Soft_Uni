package bg.softuni.core;

import bg.softuni.commands.*;
import bg.softuni.enums.CoreType;
import bg.softuni.enums.FragmentType;
import bg.softuni.interfaces.Command;
import bg.softuni.interfaces.CommandDispatcher;
import bg.softuni.interfaces.PowerPlant;

public class CommandInterpreter implements CommandDispatcher {

    private NuclearPowerPlant nuclearPowerPlant;

    public CommandInterpreter() {
        this.nuclearPowerPlant = new NuclearPowerPlant();
    }

    public PowerPlant getNuclearPowerPlant() {
        return this.nuclearPowerPlant;
    }

    public void setNuclearPowerPlant(NuclearPowerPlant nuclearPowerPlant) {
        this.nuclearPowerPlant = nuclearPowerPlant;
    }

    public Command dispatchCommand(String commandName, String[] arguments) {
        Command command = null;

        switch (commandName) {
            case "CreateCore":
                command = new CreateCoreCommand(this.getNuclearPowerPlant(), CoreType.valueOf(arguments[0]), this.getNuclearPowerPlant().getNextCoreName(), Integer.parseInt(arguments[1]));
                break;
            case "RemoveCore":
                command = new RemoveCoreCommand(this.getNuclearPowerPlant(), arguments[0]);
                break;
            case "SelectCore":
                command = new SelectCommand(this.getNuclearPowerPlant(), arguments[0]);
                break;
            case "AttachFragment":
                command = new AttachFragmentCommand(this.getNuclearPowerPlant(), FragmentType.valueOf(arguments[0]), arguments[1], Integer.parseInt(arguments[2]));
                break;
            case "DetachFragment":
                command = new DetachFragmentCommand(this.getNuclearPowerPlant());
                break;
            case "Status":
                command = new StatusCommand(this.getNuclearPowerPlant());
                break;
            case "System Shutdown":
                break;
        }

        return command;
    }
}
