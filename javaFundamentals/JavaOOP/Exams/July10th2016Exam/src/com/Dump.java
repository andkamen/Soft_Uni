package com;

import com.models.hardware.Hardware;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Dump {
    private LinkedHashMap<String, Hardware> dumpedHardware;

    public Dump() {
        this.dumpedHardware = new LinkedHashMap<>();
    }

    public void dumpHardware(Hardware hardware) {
        this.dumpedHardware.put(hardware.getName(), hardware);
    }

    public Hardware restoreHardware(String hardwareName) {
        Hardware hardware = null;
        if (this.dumpedHardware.containsKey(hardwareName)) {
            hardware = this.dumpedHardware.get(hardwareName);
            this.dumpedHardware.remove(hardwareName);
        }
        return hardware;
    }

    public void destroy(String hardwareName) {
        if (this.dumpedHardware.containsKey(hardwareName)) {
            this.dumpedHardware.remove(hardwareName);
        }
    }


    public String analyze() {

        int powerHardwareComponents = 0;
        int heavyHardwareComponents = 0;
        int expressSoftwareComponents = 0;
        int lightSoftwareComponets = 0;
        int totalDumpedMemory = 0;
        int totalDumpedCapacity = 0;

        for (Hardware hardware : dumpedHardware.values()) {
            switch (hardware.getType()) {
                case "Power":
                    powerHardwareComponents++;
                    break;
                case "Heavy":
                    heavyHardwareComponents++;
                    break;
            }
            expressSoftwareComponents+=hardware.getTypeSoftwareCount("Express");
            lightSoftwareComponets += hardware.getTypeSoftwareCount("Light");

            totalDumpedMemory += hardware.getMaximumMemory() - hardware.getCurrentMemory();
            totalDumpedCapacity += hardware.getMaximumCapacity() - hardware.getCurrentCapacity();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Dump Analysis%n"))
                .append(String.format("Power Hardware Components: %d%n", powerHardwareComponents))
                .append(String.format("Heavy Hardware Components: %d%n", heavyHardwareComponents))
                .append(String.format("Express Software Components: %d%n", expressSoftwareComponents))
                .append(String.format("Light Software Components: %d%n", lightSoftwareComponets))
                .append(String.format("Total Dumped Memory: %d%n", totalDumpedMemory))
                .append(String.format("Total Dumped Capacity: %d", totalDumpedCapacity));

        return sb.toString();
    }
}
