package com.github.Boveri.controller;

import com.github.Boveri.dto.ProdutoInputDTO;
import com.github.Boveri.dto.ProdutoResponseDTO;
import com.github.Boveri.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getPoduto(){
        List<ProdutoResponseDTO> dto = ProdutoResponseDTO.creaMock();
                return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(
            @RequestBody ProdutoResponseDTO inputDTO){
        ProdutoResponseDTO dto = new ProdutoResponseDTO(1L, inputDTO.getNome(), inputDTO.getDescricao(), inputDTO.getValor());

        return ResponseEntity.created(null).body(dto);
    }

}
