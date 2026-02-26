package com.github.Boveri.service;

import com.github.Boveri.dto.ProdutoDTO;
import com.github.Boveri.entities.Produto;
import com.github.Boveri.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Transactional
    public ProdutoDTO saveProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        //método auxiliar para converter DTO para entidade produto
        copyDtoToProduto(produtoDTO, produto);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    private void copyDtoToProduto(ProdutoDTO produtoDTO, Produto produto){

        produto.setNome(produtoDTO.getName());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produto.getValor());
    }

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAllProdutos(){

        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findProdutoById(Long id){

        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado. ID: "+id)
        );

        return new ProdutoDTO(produto);
    }

}
