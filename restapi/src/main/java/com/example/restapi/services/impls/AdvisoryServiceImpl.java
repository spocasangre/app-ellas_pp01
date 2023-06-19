package com.example.restapi.services.impls;

import com.example.restapi.models.entities.AdvisorType;
import com.example.restapi.models.entities.Advisory;
import com.example.restapi.repositories.AdvisoryRepository;
import com.example.restapi.services.AdvisoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisoryServiceImpl implements AdvisoryService {

    @Autowired
    AdvisoryRepository advisoryRepository;

    @Override
    @Async
    public List<Advisory> getAdvisoriesByAdvisorType(AdvisorType advisorType) {
        List<Advisory> advisoryList = advisoryRepository.getAdvisoriesByAdvisorType(advisorType).get();
        return advisoryList;
    }

    @Override
    public Void save(Advisory advisory) {
        advisoryRepository.save(advisory);
        return null;
    }

    @Override
    @Async
    public Advisory findById(Long id) {
        return advisoryRepository.findById(id).get();
    }

    @Override
    public Void delete(Advisory advisory) {
        advisoryRepository.delete(advisory);
        return null;
    }
}
