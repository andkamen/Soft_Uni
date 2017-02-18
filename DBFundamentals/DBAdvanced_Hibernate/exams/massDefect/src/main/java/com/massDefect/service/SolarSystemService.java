package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.SolarSystemImportJSONDto;
import com.massDefect.domain.models.SolarSystem;

public interface SolarSystemService {

    void create(SolarSystemImportJSONDto solarSystemDto);

    SolarSystem findByName(String name);

    SolarSystem findById(Long id);
}