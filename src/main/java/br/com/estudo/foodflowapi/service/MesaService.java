package br.com.estudo.foodflowapi.service;

import br.com.estudo.foodflowapi.database.model.entity.MesaEntity;
import br.com.estudo.foodflowapi.database.model.enums.StatusMesa;
import br.com.estudo.foodflowapi.database.repository.MesaRepository;
import br.com.estudo.foodflowapi.dto.MesaDTO;
import br.com.estudo.foodflowapi.exception.BadRequestException;
import br.com.estudo.foodflowapi.mapper.MesaMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MesaService {
    private final MesaRepository mesaRepository;
    private final MesaMapper mesaMapper;

    public MesaService(MesaRepository mesaRepository, MesaMapper mesaMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaMapper = mesaMapper;
    }

    public void criarMesa(MesaDTO mesaDTO) {
        MesaEntity entity = mesaMapper.toEntity(mesaDTO);
        mesaRepository.save(entity);
    }

    public List<MesaDTO> listarMesas() {
        List<MesaEntity> entities = mesaRepository.findAll();
        return mesaMapper.toDtoList(entities);
    }

}
