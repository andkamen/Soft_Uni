package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.AnomalyImportJSONDto;
import com.massDefect.domain.dto.jsonDtos.AnomalyVictimImportJSONDto;
import com.massDefect.domain.dto.xmlDtos.AnomalyXMLDto;
import com.massDefect.domain.models.Anomaly;

public interface AnomalyService {

    void create(AnomalyImportJSONDto anomalyImportJSONDto);

    void create(AnomalyXMLDto anomalyImportXMLDto);

    void fillVictims(AnomalyVictimImportJSONDto anomalyVictimDto);

    Anomaly findById(Long id);
}