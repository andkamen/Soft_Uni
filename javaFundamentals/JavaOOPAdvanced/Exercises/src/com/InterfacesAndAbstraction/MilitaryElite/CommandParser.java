package com.InterfacesAndAbstraction.MilitaryElite;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ISoldier;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommandParser {

    private HashMap<String, ISoldier> soldiersById;
    private SoldierFactory soldierFactory;

    public CommandParser(SoldierFactory soldierFactory) {
        this.soldierFactory = soldierFactory;
        this.soldiersById = new LinkedHashMap<>();
    }

    public void parseCommand(String command) {
        String[] commandArgs = command.split("\\s+");

        ISoldier soldier = null;
        switch (commandArgs[0]) {
            case "End":
                for (ISoldier aSoldier : soldiersById.values()) {
                    System.out.println(aSoldier.toString().trim());
                }
                break;
            default:
                soldier = this.soldierFactory.createSoldier(commandArgs);
                if (soldier != null) {
                    this.soldiersById.put(soldier.getId(), soldier);
                }
                break;
        }
    }
}
