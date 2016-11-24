package com.massDefect.domain.dto.jsonDtos;

public class PersonImportDto {

    private String name;

    private String homePlanet;

    public PersonImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
}
