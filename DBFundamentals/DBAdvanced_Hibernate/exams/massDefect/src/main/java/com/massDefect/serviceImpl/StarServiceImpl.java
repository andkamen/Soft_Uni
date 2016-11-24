package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.StarImportDto;
import com.massDefect.domain.models.SolarSystem;
import com.massDefect.domain.models.Star;
import com.massDefect.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.massDefect.repositories.StarRepository;
import com.massDefect.service.StarService;

@Service
@Transactional
public class StarServiceImpl implements StarService {

    @Autowired
    private StarRepository starRepository;

    @Autowired
    private SolarSystemService solarSystemService;

    @Override
    public void create(StarImportDto starDto) {

        if (starDto == null || starDto.getName() == null || starDto.getSolarSystem() == null) {
            throw new NullPointerException();
        }

        Star star = new Star();
        star.setName(starDto.getName());

        SolarSystem solarSystem = this.solarSystemService.findByName(starDto.getSolarSystem());
        if (solarSystem == null) {
            throw new NullPointerException();
        }

        star.setSolarSystem(solarSystem);

        this.starRepository.saveAndFlush(star);
    }


    @Override
    public Star findByName(String name) {
        return this.starRepository.findByName(name);
    }

    @Override
    public Star findById(Long id) {
        return this.starRepository.findById(id);
    }
}