package com.example.restapi.repositories;

import com.example.restapi.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRespository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByCodigo(String codigo);

    Optional<Usuario> findByTelefono(Integer telefono);

    Boolean existsByCorreo(String correo);

    @Query("SELECT u FROM usuario u WHERE u.rol <> 2")
    List<Usuario> findAllUsers();
}
