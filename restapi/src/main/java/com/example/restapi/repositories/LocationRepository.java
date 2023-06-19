package com.example.restapi.repositories;

import com.example.restapi.models.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l From ubicacion l WHERE l.id = ?1")
    public Location getLocationDetail(Long id);

    @Query("SELECT l From ubicacion l WHERE l.maps_id = ?1")
    public Location getLocationDetailByMapId(String id);
}
