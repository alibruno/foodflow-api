package br.com.estudo.foodflowapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoDTO(

        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        @PositiveOrZero
        BigDecimal precoAtual,

        @NotBlank
        String categoria

) {
}
