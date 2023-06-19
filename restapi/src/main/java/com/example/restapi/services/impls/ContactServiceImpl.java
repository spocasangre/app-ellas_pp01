package com.example.restapi.services.impls;

import com.example.restapi.models.entities.Contact;
import com.example.restapi.repositories.ContactRepository;
import com.example.restapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Void save(Contact contact) {
        contactRepository.save(contact);
        return null;
    }

    @Override
    @Async
    public List<Contact> getUserContactList(Long id) {
        return contactRepository.getUserContactList(id);
    }

    @Override
    public Void delete(Contact contact) {
        contactRepository.delete(contact);
        return null;
    }

    @Override
    @Async
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }
}
