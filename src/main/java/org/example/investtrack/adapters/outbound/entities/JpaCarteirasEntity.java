package org.example.investtrack.adapters.outbound.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaCarteirasEntity {

    @Id
    @Column(name = "id")
    private UUID idCarteira;

    @Column(name = "cliente_id")
    private UUID idCliente;

    private String nome;

    private String descricao;

    @Column(name = "criado_em")
    private LocalDateTime dataCriacao;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
