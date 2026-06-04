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
import org.example.investtrack.Domain.model.relatorios.Statusimp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "apuracao_ir")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaRelatorioIrEntity {

    @Id
    @Column(name = "id")
    private UUID idRelatorio;

    @Column(name = "portfolio_id")
    private UUID idCarteira;

    private String competencia;

    @Column(name = "resultado_swing_trade")
    private BigDecimal resultadoSwingTrade;

    @Column(name = "resultado_day_trade")
    private BigDecimal resultadoDayTrade;

    @Column(name = "ir_devido")
    private BigDecimal irDevido;

    @Enumerated(EnumType.STRING)
    private Statusimp status;

    @Column(name = "criado_em")
    private LocalDateTime dataCriacao;
}
