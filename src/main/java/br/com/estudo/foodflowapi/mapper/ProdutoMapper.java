package br.com.estudo.foodflowapi.mapper;

import br.com.estudo.foodflowapi.database.model.entity.ProdutoEntity;
import br.com.estudo.foodflowapi.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// O componentModel = "spring" transforma a interface em um Bean injetável
@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // O MapStruct gera a conversão inteira sozinho
    @Mapping(target = "id", ignore = true)
    ProdutoEntity toEntity(ProdutoDTO dto);

    ProdutoDTO toDto(ProdutoEntity entity);

    List<ProdutoDTO> toDtoList(List<ProdutoEntity> entities);
}
