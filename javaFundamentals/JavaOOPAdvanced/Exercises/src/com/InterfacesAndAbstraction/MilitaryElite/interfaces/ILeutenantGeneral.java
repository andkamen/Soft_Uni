package com.InterfacesAndAbstraction.MilitaryElite.interfaces;

import java.util.List;

public interface ILeutenantGeneral {
    List<ISoldier> getPrivates();

    void addSoldier(ISoldier soldier);
}
