package com.massDefect.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.massDefect.domain.models.SolarSystem;

@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {

    SolarSystem findByName(String name);

    SolarSystem findById(Long id);
}