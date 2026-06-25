package br.com.estudo.foodflowapi.service;

import br.com.estudo.foodflowapi.database.model.entity.ProdutoEntity;
import br.com.estudo.foodflowapi.database.repository.ProdutoRepository;
import br.com.estudo.foodflowapi.dto.ProdutoDTO;
import br.com.estudo.foodflowapi.mapper.ProdutoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public void criarProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = produtoMapper.toEntity(produtoDTO);
        produtoRepository.save(produtoEntity);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoEntity> produtoEntities = produtoRepository.findAll();
        return produtoMapper.toDtoList(produtoEntities);
    }
}
