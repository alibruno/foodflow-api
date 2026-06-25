package br.com.estudo.foodflowapi.controller;

import br.com.estudo.foodflowapi.dto.MesaDTO;
import br.com.estudo.foodflowapi.service.MesaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mesas")
public class MesaController {
    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMesa(@Valid @RequestBody MesaDTO mesaDTO) {
        mesaService.criarMesa(mesaDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDTO> listarMesas() {
        return mesaService.listarMesas();
    }

}
