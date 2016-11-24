package com.massDefect.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.massDefect.domain.models.Anomaly;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly,Long> {

    Anomaly findById(Long id);
}