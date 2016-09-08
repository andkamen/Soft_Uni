package commands;

import core.contracts.RecyclingStation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utilities.Messages;
import wasteDisposal.Contracts.GarbageProcessor;
import wasteDisposal.Contracts.ProcessingData;
import wasteDisposal.Contracts.Waste;
import wasteDisposal.enums.GarbageType;
import wasteDisposal.models.garbage.BurnableGarbage;
import wasteDisposal.models.garbage.RecyclableGarbage;
import wasteDisposal.models.garbage.StorableGarbage;

public class ProcessGarbageCommand extends BaseCommand {
    private GarbageProcessor garbageProcessor;
    private String[] arguments;
    private Waste garbage;

    public ProcessGarbageCommand(RecyclingStation recyclingStation, GarbageProcessor garbageProcessor, String[] arguments) {
        super(recyclingStation);
        this.garbageProcessor = garbageProcessor;
        this.arguments = arguments;
    }

    @Override
    public String execute() {
        String name = arguments[0];
        double weight = Double.parseDouble(arguments[1]);
        double volumePerKg = Double.parseDouble(arguments[2]);
        GarbageType type = Enum.valueOf(GarbageType.class, arguments[3].toUpperCase());

        switch (type) {
            case RECYCLABLE:
                this.garbage = new RecyclableGarbage(name, weight, volumePerKg);
                break;
            case BURNABLE:
                this.garbage = new BurnableGarbage(name, weight, volumePerKg);
                break;
            case STORABLE:
                this.garbage = new StorableGarbage(name, weight, volumePerKg);
                break;
        }

        ProcessingData processingData=this.garbageProcessor.processWaste(garbage);
        this.getRecyclingStation().processGarbage(processingData);

       return String.format(Messages.GARBAGE_SUCCESSFULLY_PROCESSED,this.garbage.getWeight(),this.garbage.getName());
    }
}
