package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.SolarSystemImportDto;
import com.massDefect.domain.models.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.massDefect.repositories.SolarSystemRepository;
import com.massDefect.service.SolarSystemService;

@Service
@Transactional
public class SolarSystemServiceImpl implements SolarSystemService {

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Override
    public void create(SolarSystemImportDto solarSystemDto) {

        if (solarSystemDto == null || solarSystemDto.getName() == null) {
            throw new NullPointerException();
        }

        SolarSystem solarSystem = new SolarSystem();
        solarSystem.setName(solarSystemDto.getName());

        this.solarSystemRepository.saveAndFlush(solarSystem);
    }

    @Override
    public SolarSystem findByName(String name) {
        return this.solarSystemRepository.findByName(name);
    }

    @Override
    public SolarSystem findById(Long id) {
        return this.solarSystemRepository.findById(id);
    }
}