package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.PersonImportJSONDto;
import com.massDefect.domain.models.Person;

public interface PersonService {

    void create(PersonImportJSONDto personDto);

    Person findByName(String name);
}