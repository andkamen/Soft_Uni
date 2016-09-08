package wasteDisposal.models;

import wasteDisposal.Contracts.ProcessingData;

public class ProcessedData implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public ProcessedData(double energyBalance, double capitalBalance) {
        this.energyBalance = energyBalance;
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
