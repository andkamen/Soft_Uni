package com.massDefect.service;

import com.massDefect.domain.dto.jsonDtos.PersonImportDto;
import com.massDefect.domain.models.Person;

public interface PersonService {

    void create(PersonImportDto personDto);

    Person findByName(String name);
}