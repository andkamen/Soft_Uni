package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.PlanetImportDto;
import com.massDefect.domain.models.Planet;

public interface PlanetService {

    void create(PlanetImportDto planetImportDto);

    Planet findByName(String name);
}