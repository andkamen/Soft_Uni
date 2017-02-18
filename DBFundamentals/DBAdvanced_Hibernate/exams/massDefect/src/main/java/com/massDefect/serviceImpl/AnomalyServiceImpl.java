package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.AnomalyImportJSONDto;
import com.massDefect.domain.dto.jsonDtos.AnomalyVictimImportJSONDto;
import com.massDefect.domain.dto.xmlDtos.AnomalyXMLDto;
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
    public void create(AnomalyImportJSONDto anomalyImportJSONDto) {
        if (anomalyImportJSONDto == null ||
                anomalyImportJSONDto.getOriginPlanetName() == null ||
                anomalyImportJSONDto.getTeleportPlanetName() == null) {
            throw new NullPointerException();
        }

        Anomaly anomaly = new Anomaly();
        Planet originPlanet = this.planetService.findByName(anomalyImportJSONDto.getOriginPlanetName());
        Planet teleportPlanet = this.planetService.findByName(anomalyImportJSONDto.getTeleportPlanetName());

        if (originPlanet == null || teleportPlanet == null) {
            throw new NullPointerException();
        }

        anomaly.setOriginPlanet(originPlanet);
        anomaly.setTeleportPlanet(teleportPlanet);

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public void create(AnomalyXMLDto anomalyImportXMLDto) {
        if (anomalyImportXMLDto == null ||
                anomalyImportXMLDto.getOriginPlanetName() == null ||
                anomalyImportXMLDto.getTeleportPlanetName() == null ||
                anomalyImportXMLDto.getVictims() == null){
            throw new NullPointerException();
        }

        Anomaly anomaly = new Anomaly();
        Planet originPlanet = this.planetService.findByName(anomalyImportXMLDto.getOriginPlanetName());
        Planet teleportPlanet = this.planetService.findByName(anomalyImportXMLDto.getTeleportPlanetName());

        if (originPlanet == null || teleportPlanet == null) {
            throw new NullPointerException();
        }

        anomaly.setOriginPlanet(originPlanet);
        anomaly.setTeleportPlanet(teleportPlanet);

        this.anomalyRepository.saveAndFlush(anomaly);
    }

    @Override
    public void fillVictims(AnomalyVictimImportJSONDto anomalyVictimDto) {
        if (anomalyVictimDto == null ||
                anomalyVictimDto.getId() == null ||
                anomalyVictimDto.getPersonName() == null) {
            throw new NullPointerException();
        }

        Anomaly anomaly = this.anomalyRepository.findById(anomalyVictimDto.getId());
        Person person = this.personService.findByName(anomalyVictimDto.getPersonName());
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