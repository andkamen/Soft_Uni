package bg.softuni.commands;

import bg.softuni.interfaces.Command;
import bg.softuni.interfaces.PowerPlant;

public abstract class BaseCommand implements Command{

    private PowerPlant powerPlant;

    protected BaseCommand(PowerPlant powerPlant) {
        this.setPowerPlant(powerPlant);
    }

    protected PowerPlant getPowerPlant() {
        return this.powerPlant;
    }

    protected void setPowerPlant(PowerPlant value) {
        this.powerPlant = value;
    }

    @Override
    public abstract String execute();
}
