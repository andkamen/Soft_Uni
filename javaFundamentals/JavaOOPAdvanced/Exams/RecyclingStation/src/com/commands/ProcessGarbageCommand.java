package com.commands;

import com.core.contracts.ManagementRequirement;
import com.core.contracts.RecyclingStation;
import com.core.contracts.WasteFactory;
import com.utilities.Messages;
import com.wasteDisposal.Contracts.GarbageProcessor;
import com.wasteDisposal.Contracts.ProcessingData;
import com.wasteDisposal.Contracts.Waste;
import com.wasteDisposal.enums.GarbageType;

public class ProcessGarbageCommand extends BaseCommand {
    private GarbageProcessor garbageProcessor;
    private WasteFactory wasteFactory;
    private String[] arguments;
    private Waste garbage;
    private ManagementRequirement managementRequirement;

    public ProcessGarbageCommand(RecyclingStation recyclingStation, GarbageProcessor garbageProcessor, WasteFactory wasteFactory, String[] arguments) {
        super(recyclingStation);
        this.garbageProcessor = garbageProcessor;
        this.arguments = arguments;
        this.wasteFactory = wasteFactory;
        this.managementRequirement = this.getRecyclingStation().getManagementRequirement();
    }

    @Override
    public String execute() {
        this.garbage = wasteFactory.createWaste(this.arguments);
        GarbageType type = Enum.valueOf(GarbageType.class, arguments[3].toUpperCase());

        if (this.managementRequirement != null &&
                this.managementRequirement.getGarbageTypeRequirement().equals(type) &&
                (this.getRecyclingStation().getEnergyBalance() < this.managementRequirement.getEnergyBalanceRequirement() ||
                        this.getRecyclingStation().getCapitalBalance() < this.managementRequirement.getCapitalBalanceRequirement())
                ) {
            return Messages.GARBAGE_PROCESS_DENIED;
        }

        ProcessingData processingData = this.garbageProcessor.processWaste(garbage);
        this.getRecyclingStation().processGarbage(processingData);

        return String.format(Messages.GARBAGE_SUCCESSFULLY_PROCESSED, this.garbage.getWeight(), this.garbage.getName());
    }
}
