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
import org.example.investtrack.Domain.model.operacoes.Tipo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "operacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaOperacoesEntity {

    @Id
    @Column(name = "id")
    private UUID id_operacao;

    @Column(name = "portfolio_id")
    private UUID id_carteira;

    private String ticker;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private int quantidade;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    @Column(name = "data_operacao")
    private Date dataOpc;

    @Column(name = "criado_em")
    private LocalDateTime dataCriacao;
}
