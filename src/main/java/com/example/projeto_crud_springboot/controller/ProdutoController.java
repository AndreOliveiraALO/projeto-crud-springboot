package com.example.projeto_crud_springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_crud_springboot.model.Produto;
import com.example.projeto_crud_springboot.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping()
    public List<Produto> listarProdutos(){
        return this.produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterProduto (@PathVariable long id){
        Produto produto = produtoService.obterProduto(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return this.produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable long id){
        this.produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }






}
