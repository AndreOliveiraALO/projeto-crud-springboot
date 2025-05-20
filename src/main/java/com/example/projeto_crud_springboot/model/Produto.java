package com.example.projeto_crud_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)   
    // foi feito assim pois a versao do oracle 11g não da suporte ao GenerationType.IDENTITY só aparti do oracle 12g 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1 )
    private Long id;

    private String nome;
    private Double preco;

    public Produto(){}

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

}
