package br.com.estudo.foodflowapi.database.repository;

import br.com.estudo.foodflowapi.database.model.entity.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<MesaEntity, Long> {
}
