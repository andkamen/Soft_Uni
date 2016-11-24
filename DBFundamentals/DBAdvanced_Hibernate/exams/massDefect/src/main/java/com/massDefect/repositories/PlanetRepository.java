package com.massDefect.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.massDefect.domain.models.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {

    Planet findByName(String name);
}