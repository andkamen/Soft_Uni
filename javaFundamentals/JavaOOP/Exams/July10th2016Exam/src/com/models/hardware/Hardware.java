package com.models.hardware;

import com.models.Component;
import com.models.software.Software;

import java.util.LinkedHashMap;

public abstract class Hardware extends Component {
    private int maximumCapacity;
    private int maximumMemory;
    private int currentCapacity;
    private int currentMemory;

    protected LinkedHashMap<String, Software> softwareComponents;

    public Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.setCurrentCapacity(maximumCapacity);
        this.setCurrentMemory(maximumMemory);
        softwareComponents = new LinkedHashMap<>();
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    protected void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getCurrentMemory() {
        return currentMemory;
    }

    protected void setCurrentMemory(int currentMemory) {
        this.currentMemory = currentMemory;
    }

    public void registerSoftware(Software software) {
        if (this.currentCapacity - software.getCapacityConsumption() < 0 ||
                this.currentMemory - software.getMemoryConsumption() < 0) {
            return;
        }
        this.currentCapacity -= software.getCapacityConsumption();
        this.currentMemory -= software.getMemoryConsumption();

        this.softwareComponents.put(software.getName(), software);
    }

    public void releaseSoftware(String softwareName) {
        if (this.softwareComponents.containsKey(softwareName)) {
            currentCapacity +=this.softwareComponents.get(softwareName).getCapacityConsumption();
            currentMemory += this.softwareComponents.get(softwareName).getMemoryConsumption();
            this.softwareComponents.remove(softwareName);
        }
    }

    public int getSoftwareCount(){
        return this.softwareComponents.size();
    }
    public int getTypeSoftwareCount(String type){
        int softwareCount = 0;
        for (Software software : softwareComponents.values()) {
            if (software.getType().equals(type)){
                    softwareCount++;
            }
        }
        return softwareCount;
    }

    @Override
    public String toString() {

        int expressSoftwareCount = this.softwareComponents.entrySet().stream().
                filter(s -> s.getValue().getType().equals("Express")).toArray().length;
        int lightSoftwareCount = this.softwareComponents.entrySet().stream().
                filter(s -> s.getValue().getType().equals("Light")).toArray().length;
        String softwareComponents = String.join(", ", this.softwareComponents.keySet()).replace("[", "").replace("]", "");

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hardware Component - %s%n", this.getName()))
                .append(String.format("Express Software Components - %d%n", expressSoftwareCount))
                .append(String.format("Light Software Components - %d%n", lightSoftwareCount))
                .append(String.format("Memory Usage: %d / %d%n", this.maximumMemory - this.currentMemory, this.maximumMemory))
                .append(String.format("Capacity Usage: %d / %d%n", this.maximumCapacity - this.currentCapacity, this.maximumCapacity))
                .append(String.format("Type: %s%n", this.getType()))
                .append(String.format("Software Components: %s%n", this.softwareComponents.size()==0?"None":softwareComponents));


        return sb.toString();
    }
}
