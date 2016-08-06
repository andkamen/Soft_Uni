package com.InterfacesAndAbstraction.MilitaryElite.interfaces;

import java.util.List;

public interface IEngineer {
    List<IRepair> getRepairs();

    void addRepir(IRepair repair);
}
