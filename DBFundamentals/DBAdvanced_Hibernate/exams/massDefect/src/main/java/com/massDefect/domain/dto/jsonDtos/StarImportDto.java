package com.massDefect.domain.dto.jsonDtos;

import java.io.Serializable;

public class StarImportDto implements Serializable {

    private String name;

    private String solarSystem;

    public StarImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(String solarSystem) {
        this.solarSystem = solarSystem;
    }
}
