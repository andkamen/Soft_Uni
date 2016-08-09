package com.commands;

import com.core.ManagementRequirementImpl;
import com.core.contracts.ManagementRequirement;
import com.core.contracts.RecyclingStation;
import com.utilities.Messages;
import com.wasteDisposal.enums.GarbageType;

public class ChangeManagementRequirementCommand extends BaseCommand {
    private String[] arguments;

    public ChangeManagementRequirementCommand(RecyclingStation recyclingStation, String[] arguments) {
        super(recyclingStation);
        this.arguments = arguments;
    }

    @Override
    public String execute() {
        double energyRequirement = Double.parseDouble(arguments[0]);
        double capitalRequirement = Double.parseDouble(arguments[1]);
        GarbageType garbageTypeRequirement = Enum.valueOf(GarbageType.class, arguments[2].toUpperCase());

        ManagementRequirement managementRequirement = new ManagementRequirementImpl(energyRequirement, capitalRequirement, garbageTypeRequirement);

        return Messages.CHANGE_MANAGEMENT_REQUIREMENT;
    }
}
