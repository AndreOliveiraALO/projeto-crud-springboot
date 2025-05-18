package com.example.projeto_crud_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_crud_springboot.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}


