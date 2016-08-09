package com.commands;

import com.core.contracts.ManagementRequirement;
import com.core.contracts.RecyclingStation;
import com.core.contracts.WasteFactory;
import com.utilities.Messages;
import com.wasteDisposal.Contracts.GarbageProcessor;
import com.wasteDisposal.Contracts.ProcessingData;
import com.wasteDisposal.Contracts.Waste;
import com.wasteDisposal.enums.GarbageType;
import com.wasteDisposal.models.garbage.BurnableGarbage;
import com.wasteDisposal.models.garbage.RecyclableGarbage;
import com.wasteDisposal.models.garbage.StorableGarbage;

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


        ProcessingData processingData = this.garbageProcessor.processWaste(garbage);
        this.getRecyclingStation().processGarbage(processingData);

        return String.format(Messages.GARBAGE_SUCCESSFULLY_PROCESSED, this.garbage.getWeight(), this.garbage.getName());
    }
}
