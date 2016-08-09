package com.core;

import com.core.contracts.WasteFactory;
import com.wasteDisposal.Contracts.Waste;
import com.wasteDisposal.enums.GarbageType;
import com.wasteDisposal.models.garbage.BurnableGarbage;
import com.wasteDisposal.models.garbage.RecyclableGarbage;
import com.wasteDisposal.models.garbage.StorableGarbage;

public class WasteFactoryImpl implements WasteFactory {


    @Override
    public Waste createWaste(String[] arguments) {
        Waste garbage = null;
        String name = arguments[0];
        double weight = Double.parseDouble(arguments[1]);
        double volumePerKg = Double.parseDouble(arguments[2]);
        GarbageType type = Enum.valueOf(GarbageType.class, arguments[3].toUpperCase());

        //TODO create factory for the garbage
        switch (type) {
            case RECYCLABLE:
               garbage = new RecyclableGarbage(name, weight, volumePerKg);
                break;
            case BURNABLE:
                garbage = new BurnableGarbage(name, weight, volumePerKg);
                break;
            case STORABLE:
                garbage = new StorableGarbage(name, weight, volumePerKg);
                break;
        }
        return garbage;
    }
}
