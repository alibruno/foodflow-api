package br.com.estudo.foodflowapi.handler;

import br.com.estudo.foodflowapi.exception.StandardErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Erros de Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorDTO> handleValidationException(MethodArgumentNotValidException ex) {

        StandardErrorDTO standardErrorDTO = StandardErrorDTO.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(ex.getBindingResult().getObjectName())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(standardErrorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardErrorDTO> handleException(Exception ex) {
        StandardErrorDTO standardErrorDTO = StandardErrorDTO.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .path("")
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(standardErrorDTO);
    }
}
