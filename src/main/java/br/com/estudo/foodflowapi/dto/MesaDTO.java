package br.com.estudo.foodflowapi.dto;

import br.com.estudo.foodflowapi.database.model.enums.StatusMesa;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record MesaDTO(

        @NotNull
        @PositiveOrZero
        Integer numeroIdentificador,

        @NotNull
        @Min(1)
        Integer capacidade,

        @NotNull
        StatusMesa status

) {
}
