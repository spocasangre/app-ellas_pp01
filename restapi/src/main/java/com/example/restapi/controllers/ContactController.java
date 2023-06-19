package com.example.restapi.controllers;

import com.example.restapi.models.dtos.CreateContactDTO;
import com.example.restapi.models.dtos.MessageResponse;
import com.example.restapi.models.entities.Contact;
import com.example.restapi.models.entities.Usuario;
import com.example.restapi.repositories.UserRepository;
import com.example.restapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    @PreAuthorize("hasRole('usuario')")
    public ResponseEntity<?> createContact(@RequestBody CreateContactDTO createContactDTO) {
        try {
            Contact contact = new Contact();
            contact.setNombre(createContactDTO.getName());
            contact.setTelefono(createContactDTO.getNumber());
            Usuario usuario = userRepository.findById(createContactDTO.getId_user()).get();
            contact.setUser(usuario);
            contact.setEmail(createContactDTO.getEmail());
            contactService.save(contact);
            return ResponseEntity.ok(new MessageResponse(true, 1, contact, "Contacto creado exitosamente!"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('usuario')")
    public ResponseEntity<?> getAllUserContacts(@PathVariable("id") Long id) {
        try {
            List<Contact> contactList = contactService.getUserContactList(id);
            return ResponseEntity.ok(new MessageResponse(true, 1, contactList, "Lista obtenida exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, "No se pudo obtener la lista de contactos"));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('usuario')")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        try {
            Contact contact = contactService.findById(id);
            contactService.delete(contact);
            return ResponseEntity.ok(new MessageResponse(true, 1, null, "Contacto eliminado!"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, "No se pudo eliminar el contacto"));
        }
    }

}

