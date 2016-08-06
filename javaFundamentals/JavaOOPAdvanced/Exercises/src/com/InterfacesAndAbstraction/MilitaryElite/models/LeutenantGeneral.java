package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ILeutenantGeneral;
import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ISoldier;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<ISoldier> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<ISoldier> getPrivates() {
        return this.privates;
    }

    @Override
    public void addSoldier(ISoldier soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        for (ISoldier aPrivate : privates) {
            sb.append(String.format("  %s",aPrivate.toString())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
