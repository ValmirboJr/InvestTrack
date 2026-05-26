package org.example.investtrack.adapters.inbound.dto;

import org.example.investtrack.Domain.model.operacoes.Tipo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

public record OperacoesRequestDTO(
        UUID id_carteira,
        String ticker,
        Tipo tipo,
        int quantidade,
        BigDecimal precoUnitario,
        Date dataOpc
) {
}
