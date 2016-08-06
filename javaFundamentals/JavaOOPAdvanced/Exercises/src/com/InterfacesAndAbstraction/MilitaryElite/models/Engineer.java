package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IEngineer;
import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IRepair;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<IRepair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<IRepair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepir(IRepair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Repairs:").append(System.lineSeparator());
        for (IRepair repair : repairs) {
            sb.append(String.format("  %s",repair.toString())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
