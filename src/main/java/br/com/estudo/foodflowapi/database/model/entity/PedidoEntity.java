package br.com.estudo.foodflowapi.database.model.entity;

import br.com.estudo.foodflowapi.database.model.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_hora_abertura")
    private LocalDateTime dataHoraAbertura;

    @Column(nullable = false, name = "data_hora_fechamento")
    private LocalDateTime dataHoraFechamento;

    // Atribuir diretamente age como se fosse um valor padrão
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status = StatusPedido.ABERTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mesa_id", nullable = false)
    private MesaEntity mesa;
}
