package com.core.contracts;

import com.wasteDisposal.enums.GarbageType;

public interface ManagementRequirement {

    double getEnergyBalanceRequirement();

    double getCapitalBalanceRequirement();

    GarbageType getGarbageTypeRequirement();

}
