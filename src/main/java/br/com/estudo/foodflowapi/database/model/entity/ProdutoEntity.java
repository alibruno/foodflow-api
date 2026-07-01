package br.com.estudo.foodflowapi.database.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String descricao;

    @Column(nullable = false, name = "preco_atual")
    BigDecimal precoAtual;

    @Column(nullable = false)
    String categoria;
}
