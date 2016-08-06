package com.InterfacesAndAbstraction.MilitaryElite;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IMission;
import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IRepair;
import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ISoldier;
import com.InterfacesAndAbstraction.MilitaryElite.models.*;

import java.util.HashMap;

public class SoldierFactory {
    private HashMap<String, ISoldier> privatesById;

    public SoldierFactory() {
        this.privatesById = new HashMap<>();
    }

    public ISoldier createSoldier(String[] params) {
        String type = params[0];
        String id = params[1];
        String firstName = params[2];
        String lastName = params[3];
        Double salary;
        String corps;

        switch (type) {
            case "Private":
                salary = Double.parseDouble(params[4]);
                Private aPrivate = new Private(id, firstName, lastName, salary);
                this.privatesById.put(id, aPrivate);
                return aPrivate;

            case "Spy":
                int codeNumber = Integer.parseInt(params[4]);
                Spy spy = new Spy(id, firstName, lastName, codeNumber);
                return spy;

            case "Engineer":
                salary = Double.parseDouble(params[4]);
                corps = params[5];
                Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);

                for (int i = 6; i < params.length; i += 2) {
                    String partName = params[i];
                    int hoursWorked = Integer.parseInt(params[i + 1]);
                    IRepair repair = new Repair(partName, hoursWorked);
                    engineer.addRepir(repair);
                }
                return engineer;

            case "Commando":
                salary = Double.parseDouble(params[4]);
                corps = params[5];
                Commando commando = new Commando(id, firstName, lastName, salary, corps);
                for (int i = 6; i < params.length; i += 2) {
                    try {
                        String codeName = params[i];
                        String missionState = params[i + 1];
                        IMission mission = new Mission(codeName, missionState);
                        commando.addMission(mission);
                    } catch (IllegalArgumentException iae) {
                        //illegal mission state
                    }
                }
                return commando;

            case "LeutenantGeneral":
                salary = Double.parseDouble(params[4]);
                LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);

                for (int i = 5; i < params.length; i++) {
                    leutenantGeneral.addSoldier(this.privatesById.get(params[i]));
                }

                return leutenantGeneral;

            default:
                return null;
        }
    }
}
