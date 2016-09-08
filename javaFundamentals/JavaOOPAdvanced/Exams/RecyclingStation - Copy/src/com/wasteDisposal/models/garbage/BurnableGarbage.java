package com.wasteDisposal.models.garbage;

import com.wasteDisposal.Annotations.Burnable;

@Burnable
public class BurnableGarbage extends Garbage {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
