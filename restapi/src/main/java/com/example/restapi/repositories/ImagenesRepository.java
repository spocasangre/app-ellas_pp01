package com.example.restapi.repositories;

import com.example.restapi.models.entities.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesRepository extends JpaRepository<Imagenes, Long> {

}
