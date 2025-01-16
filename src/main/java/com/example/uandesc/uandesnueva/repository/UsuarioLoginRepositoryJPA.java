package com.example.uandesc.uandesnueva.repository;

import com.example.uandesc.uandesnueva.models.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioLoginRepositoryJPA extends JpaRepository<UsuarioLogin, Long> {

    Optional<UsuarioLogin> findByNombre(String nombre);
}
