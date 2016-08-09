package bg.softuni.commands;

import bg.softuni.enums.FragmentType;
import bg.softuni.exceptions.NoSelectedCoreException;
import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Constants;
import bg.softuni.utilities.Messages;

import java.lang.reflect.Constructor;

public class AttachFragmentCommand extends BaseCommand {

    private FragmentType lateInstantiationFragmentType;

    private String lateInstantiationFragmentName;

    private Integer lateInstantiationFragmentPressureAffection;

    public AttachFragmentCommand(PowerPlant powerPlant, FragmentType fragmentType, String fragmentName, Integer fragmentPressureAffection) {
        super(powerPlant);
        this.setLateInstantiationFragmentType(fragmentType);
        this.setLateInstantiationFragmentName(fragmentName);
        this.setLateInstantiationFragmentPressureAffection(fragmentPressureAffection);
    }

    protected FragmentType getLateInstantiationFragmentType() {
        return lateInstantiationFragmentType;
    }

    protected void setLateInstantiationFragmentType(FragmentType value) {
        this.lateInstantiationFragmentType = value;
    }

    protected String getLateInstantiationFragmentName() {
        return lateInstantiationFragmentName;
    }

    protected void setLateInstantiationFragmentName(String value) {
        this.lateInstantiationFragmentName = value;
    }

    protected Integer getLateInstantiationFragmentPressureAffection() {
        return lateInstantiationFragmentPressureAffection;
    }

    protected void setLateInstantiationFragmentPressureAffection(Integer value) {
        this.lateInstantiationFragmentPressureAffection = value;
    }

    @Override
    public String execute() {
        String result = null;

        try {
            Constructor ctor = Class.forName(Constants.FRAGMENTS_PACKAGE_NAME + this.getLateInstantiationFragmentType().toString() + Constants.FRAGMENT_MODEL_NAME_SUFFIX).getConstructor(String.class, Integer.class);
            Fragment newFragment = (Fragment) ctor.newInstance(this.getLateInstantiationFragmentName(), this.getLateInstantiationFragmentPressureAffection());

            this.getPowerPlant().attachFragment(newFragment);
            result = String.format(Messages.SUCCESS_FRAGMENT_ATTACH_MESSAGE, newFragment.getName(), this.getPowerPlant().getCurrentlySelectedCore().getName());
        } catch (NoSelectedCoreException e) {
            result = String.format(Messages.FAILURE_FRAGMENT_ATTACH_MESSAGE, this.getLateInstantiationFragmentName());
        } catch (Exception e) {
            result = String.format(Messages.FAILURE_FRAGMENT_ATTACH_MESSAGE, this.getLateInstantiationFragmentName());
        }

        return result;
    }
}
