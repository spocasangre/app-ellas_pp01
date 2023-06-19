package com.example.restapi.repositories;

import com.example.restapi.models.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM contacto c WHERE c.user.id = ?1")
    public List<Contact> getUserContactList(Long id);

}
