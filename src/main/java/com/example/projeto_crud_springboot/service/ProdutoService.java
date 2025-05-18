package com.example.projeto_crud_springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto_crud_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.projeto_crud_springboot.model.Produto;
import com.example.projeto_crud_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto obterProduto(long id){
        return produtoRepository.findById(id).orElseThrow(
            () -> new RecursoNaoEncontradoException("Produto de id "+id+" não encontrado!")); 
    }
    
    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void excluirProduto(long id){
        if (!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id "+id+" não encontrado!");
        }
        produtoRepository.deleteById(id);
    }



}
