package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.PlanetImportJSONDto;
import com.massDefect.domain.models.Planet;

public interface PlanetService {

    void create(PlanetImportJSONDto planetImportJSONDto);

    Planet findByName(String name);
}