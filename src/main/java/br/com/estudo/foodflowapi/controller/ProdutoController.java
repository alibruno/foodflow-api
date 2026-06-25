package br.com.estudo.foodflowapi.controller;

import br.com.estudo.foodflowapi.dto.ProdutoDTO;
import br.com.estudo.foodflowapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoService.criarProduto(produtoDTO);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
