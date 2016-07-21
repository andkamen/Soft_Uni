package com.components.software;

public class LightSoftware extends Software {

    public LightSoftware(String name,
                         String type,
                         int capacityConsumption,
                         int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);

        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + (int)(capacityConsumption*0.5));
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - + (int)(memoryConsumption*0.5));
    }
}
