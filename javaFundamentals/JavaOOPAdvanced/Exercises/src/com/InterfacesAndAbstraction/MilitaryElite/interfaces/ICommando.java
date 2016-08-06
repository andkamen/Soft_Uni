package com.InterfacesAndAbstraction.MilitaryElite.interfaces;

import java.util.List;

public interface ICommando {
    List<IMission> getMissions();

    void addMission(IMission mission);
}
