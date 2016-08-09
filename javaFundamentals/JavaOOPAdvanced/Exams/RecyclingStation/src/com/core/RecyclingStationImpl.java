package com.core;

import com.core.contracts.ManagementRequirement;
import com.core.contracts.RecyclingStation;
import com.utilities.Constants;
import com.utilities.Messages;
import com.wasteDisposal.Contracts.ProcessingData;

public class RecyclingStationImpl implements RecyclingStation {

    private double energyBalance;
    private double capitalBalance;
    private ManagementRequirement managementRequirement;

    public RecyclingStationImpl() {
        this.energyBalance = Constants.RECYCLING_STATION_DEFAULT_ENERGY;
        this.capitalBalance = Constants.RECYCLING_STATION_DEFAULT_CAPITAL;
        this.managementRequirement = null;
    }

    @Override
    public void changeManagementRequirement(ManagementRequirement managementRequirement) {
        this.managementRequirement = managementRequirement;
    }

    @Override
    public void processGarbage(ProcessingData processingData) {
        this.energyBalance += processingData.getEnergyBalance();
        this.capitalBalance += processingData.getCapitalBalance();
    }

    @Override
    public ManagementRequirement getManagementRequirement() {
        return this.managementRequirement;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    @Override
    public String toString() {
        return String.format(Messages.RECYCLING_STATION_STATUS, getEnergyBalance(), getCapitalBalance());
    }
}
