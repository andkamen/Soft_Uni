package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.ICommando;
import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IMission;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<IMission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public List<IMission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(IMission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Missions:").append(System.lineSeparator());
        for (IMission mission : missions) {
            sb.append(String.format("  %s",mission.toString())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
