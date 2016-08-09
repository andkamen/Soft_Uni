package bg.softuni.commands;

import bg.softuni.exceptions.UnexistentCoreException;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Messages;

public class RemoveCoreCommand extends BaseCommand {

    private String lateRemovingCoreName;

    public RemoveCoreCommand(PowerPlant powerPlant, String coreName) {
        super(powerPlant);
        this.setLateRemovingCoreName(coreName);
    }

    protected String getLateRemovingCoreName() {
        return this.lateRemovingCoreName;
    }

    protected void setLateRemovingCoreName(String value) {
        this.lateRemovingCoreName = value;
    }

    @Override
    public String execute() {
        String result = null;

        try {
            Core detachedCore = this.getPowerPlant().detachCore(this.getLateRemovingCoreName());
            result = String.format(Messages.SUCCESS_CORE_REMOVE_MESSAGE, detachedCore.getName());
        } catch(UnexistentCoreException e) {
            result = String.format(Messages.FAILURE_CORE_REMOVE_MESSAGE, this.getLateRemovingCoreName());
        } catch (Exception e) {
            result = String.format(Messages.FAILURE_CORE_REMOVE_MESSAGE, this.getLateRemovingCoreName());
        }

        return result;
    }
}
