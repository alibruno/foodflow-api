package br.com.estudo.foodflowapi.database.model.entity;

import br.com.estudo.foodflowapi.database.model.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mesas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "numero_identificador")
    private Integer numeroIdentificador;

    @Column(nullable = false)
    private Integer capacidade;

    @Builder.Default // Obriga o Builder a respeitar este valor inicial
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMesa status = StatusMesa.DISPONIVEL;
    // Atribuir diretamente age como se fosse um valor padrão

    //O mappedBy aponta para o nome do atributo "mesa" lá na classe PedidoEntity.
    @Builder.Default
    @OneToMany(mappedBy = "mesa", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PedidoEntity> pedidos = new ArrayList<>();
    // Boa prática: sempre inicialize coleções vazias.
}
