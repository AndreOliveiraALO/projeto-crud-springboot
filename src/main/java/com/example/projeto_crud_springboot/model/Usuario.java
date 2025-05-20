package com.example.projeto_crud_springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id 
    // @GeneratedValue(strategy = GenerationType.IDENTITY)   
    // foi feito assim pois a versao do oracle 11g não da suporte ao GenerationType.IDENTITY só aparti do oracle 12g 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    private long id;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;

    public Usuario(){}

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
