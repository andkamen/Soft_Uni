package bg.softuni.commands;

import bg.softuni.enums.CoreType;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.PowerPlant;
import bg.softuni.utilities.Constants;
import bg.softuni.utilities.Messages;

import java.lang.reflect.Constructor;

public class CreateCoreCommand extends BaseCommand {

    private CoreType lateInstantiationCoreType;

    private String lateInstantiationCoreName;

    private Integer lateInstantiationCoreEnergyOutput;

    public CreateCoreCommand(PowerPlant powerPlant, CoreType coreType, String coreName, Integer coreEnergyOutput) {
        super(powerPlant);
        this.setLateInstantiationCoreType(coreType);
        this.setLateInstantiationCoreName(coreName);
        this.setLateInstantiationCoreEnergyOutput(coreEnergyOutput);
    }

    protected CoreType getLateInstantiationCoreType() {
        return this.lateInstantiationCoreType;
    }

    protected void setLateInstantiationCoreType(CoreType value) {
        this.lateInstantiationCoreType = value;
    }

    protected String getLateInstantiationCoreName() {
        return this.lateInstantiationCoreName;
    }

    protected void setLateInstantiationCoreName(String value) {
        this.lateInstantiationCoreName = value;
    }

    protected Integer getLateInstantiationCoreEnergyOutput() {
        return this.lateInstantiationCoreEnergyOutput;
    }

    protected void setLateInstantiationCoreEnergyOutput(Integer value) {
        this.lateInstantiationCoreEnergyOutput = value;
    }

    @Override
    public String execute() {
        String result = null;

        try {
            Constructor ctor = Class.forName(Constants.CORES_PACKAGE_NAME + this.getLateInstantiationCoreType().toString() + Constants.CORE_MODEL_NAME_SUFFIX).getConstructor(String.class, Integer.class);
            Core newCore = (Core) ctor.newInstance(this.getLateInstantiationCoreName(), this.getLateInstantiationCoreEnergyOutput());

            this.getPowerPlant().attachCore(newCore);
            result = String.format(Messages.SUCCESS_CORE_CREATE_MESSAGE, newCore.getName());
        } catch (Exception e) {
            result = Messages.FAILURE_CORE_CREATE_MESSAGE;
        }

        return result;
    }
}
