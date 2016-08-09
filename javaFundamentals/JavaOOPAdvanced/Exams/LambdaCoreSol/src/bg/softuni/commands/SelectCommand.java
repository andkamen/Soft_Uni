package bg.softuni.commands;

import bg.softuni.exceptions.UnexistentCoreException;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Messages;

public class SelectCommand extends BaseCommand{

    private String lateSelectingCoreName;

    public SelectCommand(PowerPlant powerPlant, String coreName) {
        super(powerPlant);
        this.setLateSelectingCoreName(coreName);
    }

    protected String getLateSelectingCoreName() {
        return this.lateSelectingCoreName;
    }

    protected void setLateSelectingCoreName(String value) {
        this.lateSelectingCoreName = value;
    }

    @Override
    public String execute() {
        String result = null;

        try {
            this.getPowerPlant().selectCore(this.getLateSelectingCoreName());
            result = String.format(Messages.SUCCESS_CORE_SELECT_MESSAGE, this.getPowerPlant().getCurrentlySelectedCore().getName());
        } catch (UnexistentCoreException e) {
            result = String.format(Messages.FAILURE_CORE_SELECT_MESSAGE, this.getLateSelectingCoreName());
        }


        return result;
    }
}
