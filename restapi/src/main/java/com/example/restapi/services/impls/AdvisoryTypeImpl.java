package com.example.restapi.services.impls;

import com.example.restapi.models.entities.AdvisorType;
import com.example.restapi.repositories.AdvisorTypeRepository;
import com.example.restapi.services.AdvisoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AdvisoryTypeImpl implements AdvisoryTypeService {

    @Autowired
    AdvisorTypeRepository advisorTypeRepository;

    @Override
    @Async
    public AdvisorType findById(Long id) {
        AdvisorType advisorType = advisorTypeRepository.findById(id).get();
        return advisorType;
    }
}
