package bg.softuni.commands;

import bg.softuni.interfaces.PowerPlant;

public class StatusCommand extends BaseCommand {
    public StatusCommand(PowerPlant powerPlant) {
        super(powerPlant);
    }

    @Override
    public String execute() {
        String result = this.getPowerPlant().toString();
        return result;
    }
}
