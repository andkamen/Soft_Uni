package com.core;

import com.core.contracts.ManagementRequirement;
import com.wasteDisposal.enums.GarbageType;

public class ManagementRequirementImpl implements ManagementRequirement {
    private double energyBalanceRequirement;
    private double capitalBalanceRequirement;
    private GarbageType garbageTypeRequirement;

    public ManagementRequirementImpl(double energyBalanceRequirement, double capitalBalanceRequirement, GarbageType garbageTypeRequirement) {
        this.energyBalanceRequirement = energyBalanceRequirement;
        this.capitalBalanceRequirement = capitalBalanceRequirement;
        this.garbageTypeRequirement = garbageTypeRequirement;
    }

    @Override
    public double getEnergyBalanceRequirement() {
        return this.energyBalanceRequirement;
    }

    @Override
    public double getCapitalBalanceRequirement() {
        return this.capitalBalanceRequirement;
    }

    @Override
    public GarbageType getGarbageTypeRequirement() {
        return this.garbageTypeRequirement;
    }
}
