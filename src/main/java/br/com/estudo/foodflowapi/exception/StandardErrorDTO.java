package br.com.estudo.foodflowapi.exception;

import lombok.Builder;

import java.time.Instant;

@Builder
public record StandardErrorDTO(
        Instant timestamp,
        Integer status,
        String message,
        String path
) {
}
