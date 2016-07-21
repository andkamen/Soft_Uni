package com.components.software;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name,
                           String type,
                           int capacityConsumption,
                           int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);

        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(2*memoryConsumption);
    }
}
