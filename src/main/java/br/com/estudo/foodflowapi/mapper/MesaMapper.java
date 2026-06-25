package br.com.estudo.foodflowapi.mapper;

import br.com.estudo.foodflowapi.database.model.entity.MesaEntity;
import br.com.estudo.foodflowapi.dto.MesaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesaMapper {
    MesaEntity toEntity(MesaDTO dto);

    MesaDTO toDto(MesaEntity entity);

    List<MesaDTO> toDtoList(List<MesaEntity> entities);
}
