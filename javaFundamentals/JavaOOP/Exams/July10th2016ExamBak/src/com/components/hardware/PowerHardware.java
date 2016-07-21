package com.components.hardware;

public class PowerHardware extends Hardware {

    public PowerHardware(String name,
                         String type,
                         int maximumCapacity,
                         int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);

        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity - (int) (maximumCapacity * 0.75));
        super.setCurrentCapacity(this.getMaximumCapacity());
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory + (int) (maximumMemory * 0.75));
        super.setCurrentMemory(this.getMaximumMemory());
    }
}
