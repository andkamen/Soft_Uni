package wasteDisposal.Strategies;

import utilities.Constants;
import wasteDisposal.Annotations.Storable;
import wasteDisposal.Contracts.GarbageDisposalStrategy;
import wasteDisposal.Contracts.ProcessingData;
import wasteDisposal.Contracts.Waste;
import wasteDisposal.models.ProcessedData;

@Storable
public class StorableStrategy implements GarbageDisposalStrategy {


    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = 0;
        double capital = 0;

        energy += (garbage.getVolumePerKg() * garbage.getWeight()) *
                (Constants.STORABLE_GARBAGE_ENERGY_PRODUCED - Constants.STORABLE_GARBAGE_ENERGY_USED);

        capital += garbage.getWeight() * Constants.STORABLE_GARBAGE_CAPITAL_EARNED -
                (garbage.getVolumePerKg() * garbage.getWeight()) * Constants.STORABLE_GARBAGE_CAPITAL_USED;

        ProcessingData processedData = new ProcessedData(energy, capital);

        return processedData;
    }
}
