package com.example.restapi.services;

import com.example.restapi.models.entities.Location;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface LocationService {
    Location getLocationDetail(Long id);
    Location getLocationDetailByMapId(String id);
    Void saveLocation(Location location);
    List<Location> findAll();
    Location findById(Long id);
    String inversedGeo(Double lat, Double lon) throws JsonProcessingException;
}
