package com.example.restapi.services;

import com.example.restapi.models.entities.Usuario;

public interface UserService {
    Boolean existByCorreo(String correo);
    Void save(Usuario usuario);
    Usuario findByCorreo(String correo);
    Usuario findById(Long id);
}
