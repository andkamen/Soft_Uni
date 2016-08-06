package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName,salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {

        if (!corps.equals("Airforces") && !corps.equals("Marines")) {
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Corps: %s", getCorps())).append(System.lineSeparator());

        return sb.toString();
    }
}
