package com.models.hardware;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name,
                         String type,
                         int maximumCapacity,
                         int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);

        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(2 * maximumCapacity);
        super.setCurrentCapacity(this.getMaximumCapacity());
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory - (int) (maximumMemory * 0.25));
        super.setCurrentMemory(this.getMaximumMemory());
    }
}
