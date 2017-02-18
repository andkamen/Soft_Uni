package com.massDefect.serviceImpl;

import com.massDefect.domain.dto.jsonDtos.PersonImportJSONDto;
import com.massDefect.domain.models.Person;
import com.massDefect.domain.models.Planet;
import com.massDefect.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.massDefect.repositories.PersonRepository;
import com.massDefect.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PlanetService planetService;

    @Override
    public void create(PersonImportJSONDto personDto) {
        if (personDto == null ||
                personDto.getName() == null ||
                personDto.getHomePlanetName() == null) {
            throw new NullPointerException();
        }

        Person person = new Person();
        person.setName(personDto.getName());

        Planet planet = this.planetService.findByName(personDto.getHomePlanetName());
        if (planet == null) {
            throw new NullPointerException();
        }
        person.setHomePlanet(planet);

        this.personRepository.saveAndFlush(person);
    }

    @Override
    public Person findByName(String name) {
        return this.personRepository.findByName(name);
    }
}