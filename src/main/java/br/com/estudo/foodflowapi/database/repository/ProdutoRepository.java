package br.com.estudo.foodflowapi.database.repository;

import br.com.estudo.foodflowapi.database.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
