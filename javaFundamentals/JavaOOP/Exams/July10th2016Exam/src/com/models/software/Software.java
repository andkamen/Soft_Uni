package com.models.software;

import com.models.Component;

public abstract class Software extends Component {
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
