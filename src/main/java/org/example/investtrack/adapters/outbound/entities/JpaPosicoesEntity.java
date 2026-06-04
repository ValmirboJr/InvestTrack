package org.example.investtrack.adapters.outbound.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.investtrack.Domain.model.posicoes.Ativo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaPosicoesEntity {

    @Id
    @Column(name = "id")
    private UUID idPosicao;

    @Column(name = "portfolio_id")
    private UUID idCarteira;

    private String ticker;

    private int quantidade;

    @Column(name = "preco_medio")
    private BigDecimal precoMedio;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe_ativo")
    private Ativo ativo;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
