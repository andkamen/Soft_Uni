package com.wasteDisposal.Strategies;

import com.utilities.Constants;
import com.wasteDisposal.Annotations.Storable;
import com.wasteDisposal.Contracts.GarbageDisposalStrategy;
import com.wasteDisposal.Contracts.ProcessingData;
import com.wasteDisposal.Contracts.Waste;
import com.wasteDisposal.models.ProcessedData;

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
