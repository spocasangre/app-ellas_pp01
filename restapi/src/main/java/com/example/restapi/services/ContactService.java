package com.example.restapi.services;

import com.example.restapi.models.entities.Contact;

import java.util.List;

public interface ContactService {
    Void save(Contact contact);
    List<Contact> getUserContactList(Long id);
    Void delete(Contact contact);
    Contact findById(Long id);
}
