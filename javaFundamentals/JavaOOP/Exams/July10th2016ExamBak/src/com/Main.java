package com;

import com.components.hardware.Hardware;
import com.components.hardware.HeavyHardware;
import com.components.hardware.PowerHardware;
import com.components.software.ExpressSoftware;
import com.components.software.LightSoftware;
import com.components.software.Software;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static PCSystem system;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        system = new PCSystem();
        Hardware hardware;
        Software software;

        while (true) {
            String line = reader.readLine().replace(")", "");
            String[] parameters = line.split("\\(");
           // parseCommand(parameters[0],parameters[1]);

            switch (parameters[0]) {
                case "RegisterPowerHardware":
                    hardware = registerHardware(parameters[1], "Power");
                    system.registerHardware(hardware);
                    break;
                case "RegisterHeavyHardware":
                    hardware = registerHardware(parameters[1], "Heavy");
                    system.registerHardware(hardware);
                    break;
                case "RegisterExpressSoftware":
                    String hardwareName = parameters[1].substring(0, parameters[1].indexOf(','));

                    software = registerSoftware(parameters[1], "Express");
                    system.registerSoftware(software,hardwareName);
                    break;
                case "RegisterLightSoftware":
                    hardwareName = parameters[1].substring(0, parameters[1].indexOf(','));

                    software = registerSoftware(parameters[1], "Light");
                    system.registerSoftware(software,hardwareName);
                    break;
                case "ReleaseSoftwareComponent":
                    String[] releaseInfo = parameters[1].split(", ");
                    system.releaseSoftware(releaseInfo[0],releaseInfo[1]);
                    break;
                case "Analyze":
                    System.out.println(system);
                    break;
                case "System Split":
                    String ouput = system.systemSplit();
                    System.out.println(ouput);
                    return;
            }
        }
    }

    private static void parseCommand(String command) {
    }


    private static Software registerSoftware(String parameters, String type) {
        String[] componentInfo = parameters.split(", ");

        String name = componentInfo[1];
        int capacityConsumption = Integer.valueOf(componentInfo[2]);
        int memoryConsumption = Integer.valueOf(componentInfo[3]);

        Software software = type.equals("Express") ?
                new ExpressSoftware(name, "Express", capacityConsumption, memoryConsumption) :
                new LightSoftware(name, "Light", capacityConsumption, memoryConsumption);
        return software;

    }

    private static Hardware registerHardware(String parameters, String type) {
        String[] componentInfo = parameters.split(", ");

        String name = componentInfo[0];
        int capacity = Integer.valueOf(componentInfo[1]);
        int memory = Integer.valueOf(componentInfo[2]);

        Hardware hardware = type.equals("Power") ?
                new PowerHardware(name, "Power", capacity, memory) :
                new HeavyHardware(name, "Heavy", capacity, memory);
        return hardware;
    }
}
