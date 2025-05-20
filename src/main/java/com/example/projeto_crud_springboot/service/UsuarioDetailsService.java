package com.example.projeto_crud_springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.projeto_crud_springboot.model.Usuario;
import com.example.projeto_crud_springboot.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));

        return User.builder()
            .username(usuario.getLogin())
            .password(usuario.getSenha())
            .roles("USER")
            .build(); 
    }




    

}
