package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IMission;

public class Mission implements IMission{
    private String codeName;
    private String missionState;

    public Mission(String codeName, String missionState) {
        this.codeName = codeName;
        this.setMissionState(missionState);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getMissionState() {
        return this.missionState;
    }

    private void setMissionState(String missionState){
        if (!missionState.equals("inProgress") && !missionState.equals("Finished")) {
            throw new IllegalArgumentException();
        }
        this.missionState = missionState;
    }

    @Override
    public void CompleteMission() {
        this.setMissionState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",getCodeName(),getMissionState());
    }
}
