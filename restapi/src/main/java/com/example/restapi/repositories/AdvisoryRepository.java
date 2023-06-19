package com.example.restapi.repositories;

import com.example.restapi.models.entities.AdvisorType;
import com.example.restapi.models.entities.Advisory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvisoryRepository extends JpaRepository<Advisory, Long> {

    Optional<List<Advisory>> getAdvisoriesByAdvisorType(AdvisorType advisorType);

}
