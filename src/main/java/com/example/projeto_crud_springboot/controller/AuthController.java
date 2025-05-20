package com.example.projeto_crud_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto_crud_springboot.model.Usuario;
import com.example.projeto_crud_springboot.security.JwtUtil;
import com.example.projeto_crud_springboot.service.UsuarioService;

import java.util.Map;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
       
    private final UsuarioService usuarioService;
    
    public AuthController(UsuarioService usuarioService ){
        this.usuarioService = usuarioService;       
    } 
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registrarUsuario(request.get("login"), "senha");        
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarUsuario(request.get("login"));
        if (usuario.isPresent() && usuario.get().getSenha().equals(request.get("senha"))){
            String token = JwtUtil.generateToken(usuario.get().getLogin());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credenciais Inválidas");
    }
}
