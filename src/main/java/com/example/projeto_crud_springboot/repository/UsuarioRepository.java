package com.example.projeto_crud_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_crud_springboot.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByLogin(String login);
}
