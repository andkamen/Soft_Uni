package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.AnomalyImportDto;
import com.massDefect.domain.dto.jsonDtos.AnomalyVictimImportDto;
import com.massDefect.domain.models.Anomaly;
import com.massDefect.domain.models.Person;
import com.massDefect.domain.models.Planet;
import com.massDefect.service.PersonService;
import com.massDefect.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.massDefect.repositories.AnomalyRepository;
import com.massDefect.service.AnomalyService;

@Service
@Transactional
public class AnomalyServiceImpl implements AnomalyService {

    @Autowired
    private AnomalyRepository anomalyRepository;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PersonService personService;

    @Override
    public void create(AnomalyImportDto anomalyDto) {
        if (anomalyDto == null ||
                anomalyDto.getOriginPlanet() == null ||
                anomalyDto.getTeleportPlanet() == null) {
            throw new NullPointerException();
        }

        Anomaly anomaly = new Anomaly();
        Planet originPlanet = this.planetService.findByName(anomalyDto.getOriginPlanet());
        Planet teleportPlanet = this.planetService.findByName(anomalyDto.getTeleportPlanet());

        if (originPlanet == null || teleportPlanet == null) {
            throw new NullPointerException();
        }

        anomaly.setOriginPlanet(originPlanet);
        anomaly.setTeleportPlanet(teleportPlanet);

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public void fillVictims(AnomalyVictimImportDto anomalyVictimDto) {
        if (anomalyVictimDto == null ||
                anomalyVictimDto.getId() == null ||
                anomalyVictimDto.getPerson() == null) {
            throw new NullPointerException();
        }

        Anomaly anomaly = this.anomalyRepository.findById(Long.parseLong(anomalyVictimDto.getId()));
        Person person = this.personService.findByName(anomalyVictimDto.getPerson());
        if (anomaly == null || person == null) {
            throw new NullPointerException();
        }

        anomaly.getVictims().add(person);

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public Anomaly findById(Long id) {
        return this.anomalyRepository.findById(id);
    }
}