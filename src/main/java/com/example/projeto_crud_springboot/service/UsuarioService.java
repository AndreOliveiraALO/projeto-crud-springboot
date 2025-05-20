package com.example.projeto_crud_springboot.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.projeto_crud_springboot.model.Usuario;
import com.example.projeto_crud_springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String login, String senha){
        String senhaCriptografada = passwordEncoder.encode(senha);
        Usuario usuario = new Usuario(login, senhaCriptografada);
        return this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario>buscarUsuario(String login){
        return usuarioRepository.findByLogin(login);
    } 
    
}
