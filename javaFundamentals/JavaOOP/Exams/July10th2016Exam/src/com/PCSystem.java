package com;

import com.models.hardware.Hardware;
import com.models.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class PCSystem {
    private Dump dump;
    private LinkedHashMap<String, Hardware> hardwareComponents;

    public PCSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dump = new Dump();
    }

    public void registerHardware(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void registerSoftware(Software software, String hardwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).registerSoftware(software);
        }
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    public String systemSplit() {
        StringBuilder sb = new StringBuilder();
        for (Hardware hardware : hardwareComponents.values()) {
            if (hardware.getType().equals("Power")) {
                sb.append(String.format("%s", hardware));
            }
        }

        for (Hardware hardware : hardwareComponents.values()) {
            if (hardware.getType().equals("Heavy")) {
                sb.append(String.format("%s", hardware));
            }
        }

        return sb.toString();
    }

    public void dump(String hardwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.dump.dumpHardware(this.hardwareComponents.get(hardwareName));
            this.hardwareComponents.remove(hardwareName);
        }
    }

    public void restore(String hardwareName) {
        Hardware restoredHarware = this.dump.restoreHardware(hardwareName);
        if (restoredHarware == null) {
            return;
        }
        this.hardwareComponents.put(restoredHarware.getName(), restoredHarware);
    }

    public void destroy(String hardwareName) {
        this.dump.destroy(hardwareName);
    }

    public String dumpAnalyze(){
        return this.dump.analyze();
    }

    @Override
    public String toString() {
        int softwareComponentsCount = 0;
        long totalOperationalMemoryInUse = 0;
        long maximumMemory = 0;
        long totalCapacityTaken = 0;
        long maximumCapacity = 0;

        for (Map.Entry<String, Hardware> hardwareComponent : hardwareComponents.entrySet()) {
            softwareComponentsCount += hardwareComponent.getValue().getSoftwareCount();
            totalOperationalMemoryInUse += (hardwareComponent.getValue().getMaximumMemory() - hardwareComponent.getValue().getCurrentMemory());
            maximumMemory += hardwareComponent.getValue().getMaximumMemory();
            totalCapacityTaken += (hardwareComponent.getValue().getMaximumCapacity() - hardwareComponent.getValue().getCurrentCapacity());
            maximumCapacity += hardwareComponent.getValue().getMaximumCapacity();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("System Analysis%n"))
                .append(String.format("Hardware Components: %d%n", this.hardwareComponents.size()))
                .append(String.format("Software Components: %d%n", softwareComponentsCount))
                .append(String.format("Total Operational Memory: %d / %d%n", totalOperationalMemoryInUse, maximumMemory))
                .append(String.format("Total Capacity Taken: %d / %d", totalCapacityTaken, maximumCapacity));
        return sb.toString();
    }
}
