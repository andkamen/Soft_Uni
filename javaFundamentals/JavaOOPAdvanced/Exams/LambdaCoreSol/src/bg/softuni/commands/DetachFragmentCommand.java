package bg.softuni.commands;

import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Messages;

public class DetachFragmentCommand extends BaseCommand{

    public DetachFragmentCommand(PowerPlant powerPlant) {
        super(powerPlant);
    }

    @Override
    public String execute() {
        String result = null;

        try {
            Fragment detachedFragment = this.getPowerPlant().detachFragment();
            result = String.format(Messages.SUCCESS_FRAGMENT_DETACH_MESSAGE, detachedFragment.getName(), this.getPowerPlant().getCurrentlySelectedCore().getName());
        } catch(Exception e) {
            result = Messages.FAILURE_FRAGMENT_DETACH_MESSAGE;
        }

        return result;
    }
}
