package com.example.restapi.repositories;

import com.example.restapi.models.entities.AdvisorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisorTypeRepository extends JpaRepository<AdvisorType, Long> {
}
