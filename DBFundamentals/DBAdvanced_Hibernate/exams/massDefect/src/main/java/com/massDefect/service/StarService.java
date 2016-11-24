package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.StarImportDto;
import com.massDefect.domain.models.Star;

public interface StarService {

    void create(StarImportDto starDto);

    Star findByName(String name);

    Star findById(Long id);
}