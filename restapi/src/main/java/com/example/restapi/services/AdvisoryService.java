package com.example.restapi.services;

import com.example.restapi.models.entities.AdvisorType;
import com.example.restapi.models.entities.Advisory;

import java.util.List;

public interface AdvisoryService {
    List<Advisory> getAdvisoriesByAdvisorType(AdvisorType advisorType);
    Void save(Advisory advisory);
    Advisory findById(Long id);
    Void delete(Advisory advisory);
}
