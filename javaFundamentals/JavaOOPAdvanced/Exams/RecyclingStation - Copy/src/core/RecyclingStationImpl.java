package core;

import core.contracts.RecyclingStation;
import utilities.Constants;
import utilities.Messages;
import wasteDisposal.Contracts.ProcessingData;

public class RecyclingStationImpl implements RecyclingStation {

    private double energyBalance;
    private double capitalBalance;

    public RecyclingStationImpl() {
        this.energyBalance = Constants.RECYCLING_STATION_DEFAULT_ENERGY;
        this.capitalBalance = Constants.RECYCLING_STATION_DEFAULT_CAPITAL;
    }

    @Override
    public void processGarbage(ProcessingData processingData) {
        this.energyBalance+=processingData.getEnergyBalance();
        this.capitalBalance += processingData.getCapitalBalance();
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
        return String.format(Messages.RECYCLING_STATION_STATUS,getEnergyBalance(),getCapitalBalance());
    }
}
