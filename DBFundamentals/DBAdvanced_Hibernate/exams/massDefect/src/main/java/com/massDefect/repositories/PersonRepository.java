package com.massDefect.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.massDefect.domain.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);


}