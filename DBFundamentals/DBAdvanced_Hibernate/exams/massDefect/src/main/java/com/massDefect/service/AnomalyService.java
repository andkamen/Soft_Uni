package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.AnomalyImportDto;
import com.massDefect.domain.dto.jsonDtos.AnomalyVictimImportDto;
import com.massDefect.domain.models.Anomaly;

public interface AnomalyService {

    void create(AnomalyImportDto anomalyDto);

    void fillVictims(AnomalyVictimImportDto anomalyVictimDto);

    Anomaly findById(Long id);
}