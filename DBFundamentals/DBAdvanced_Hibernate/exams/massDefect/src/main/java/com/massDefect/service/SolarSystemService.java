package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.SolarSystemImportDto;
import com.massDefect.domain.models.SolarSystem;

public interface SolarSystemService {

    void create(SolarSystemImportDto solarSystemDto);

    SolarSystem findByName(String name);

    SolarSystem findById(Long id);
}