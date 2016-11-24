package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.PlanetImportDto;
import com.massDefect.domain.models.Planet;
import com.massDefect.domain.models.SolarSystem;
import com.massDefect.domain.models.Star;
import com.massDefect.service.SolarSystemService;
import com.massDefect.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.massDefect.repositories.PlanetRepository;
import com.massDefect.service.PlanetService;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private StarService starService;

    @Autowired
    private SolarSystemService solarSystemService;

    @Override
    public void create(PlanetImportDto planetDto) {

        if (planetDto == null ||
                planetDto.getName() == null ||
                planetDto.getSolarSystem() == null ||
                planetDto.getSun() == null) {
            throw new NullPointerException();
        }

        Planet planet = new Planet();
        planet.setName(planetDto.getName());

        SolarSystem solarSystem = this.solarSystemService.findByName(planetDto.getSolarSystem());
        if (solarSystem == null) {
            throw new NullPointerException();
        }
        planet.setSolarSystem(solarSystem);

        Star star = this.starService.findByName(planetDto.getSun());
        if (star == null) {
            throw new NullPointerException();
        }
        planet.setSun(star);

        this.planetRepository.saveAndFlush(planet);
    }

    @Override
    public Planet findByName(String name) {
        return this.planetRepository.findByName(name);
    }
}