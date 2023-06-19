package com.example.restapi.controllers;

import com.example.restapi.models.dtos.EmailDTO;
import com.example.restapi.models.dtos.MessageResponse;
import com.example.restapi.models.entities.Usuario;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<Usuario> users = userRepository.findAllUsers();
            return ResponseEntity.ok(new MessageResponse(false, 1, users, "Lista obtenida correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, "No se pudo obtener la lista de usuarios"));
        }
    }

    @GetMapping("/by_email")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getUserByEmail(@RequestBody EmailDTO email) {
        try {
            Optional<Usuario> user = userRepository.findByCorreo(email.getEmail());
            return ResponseEntity.ok(new MessageResponse(false, 1, user, "Usuario obtenido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, "No se pudo obtener al usuario"));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        try {
            Optional<Usuario> user = userRepository.findById(id);
            return ResponseEntity.ok(new MessageResponse(false, 1, user, "Usuario obtenido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse(false, 7, null, "No se pudo obtener al usuario"));
        }
    }

    @DeleteMapping("/delete_user/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('usuario')")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        try {
            Usuario user = userRepository.findById(id).get();
            userRepository.delete(user);
            return ResponseEntity.ok().body(new MessageResponse(true, 1, null, "Usuario eliminado!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(false, 7, null, "Error al eliminar el usuario"));
        }
    }

}
