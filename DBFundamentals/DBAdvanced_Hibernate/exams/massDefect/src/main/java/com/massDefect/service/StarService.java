package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.StarImportJSONDto;
import com.massDefect.domain.models.Star;

public interface StarService {

    void create(StarImportJSONDto starDto);

    Star findByName(String name);

    Star findById(Long id);
}