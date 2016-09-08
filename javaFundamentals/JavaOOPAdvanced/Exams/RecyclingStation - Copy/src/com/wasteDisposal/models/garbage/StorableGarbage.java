package com.wasteDisposal.models.garbage;

import com.wasteDisposal.Annotations.Storable;

@Storable
public class StorableGarbage extends Garbage {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
