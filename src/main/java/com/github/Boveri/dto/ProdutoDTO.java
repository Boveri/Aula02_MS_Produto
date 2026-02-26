package com.github.Boveri.dto;

import com.github.Boveri.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {
    private Long id;
    private String name;
    private String descricao;
    private Double valor;

    public ProdutoDTO(Produto produto){
        id = produto.getId();
        name = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
    }
}
