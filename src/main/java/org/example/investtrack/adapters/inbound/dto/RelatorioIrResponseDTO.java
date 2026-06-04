package org.example.investtrack.adapters.inbound.dto;

import org.example.investtrack.Domain.model.relatorios.Statusimp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RelatorioIrResponseDTO(
        UUID id_relatorio,
        UUID id_carteira,
        String competencia,
        BigDecimal resultadoSwingTrade,
        BigDecimal resultadoDayTrade,
        BigDecimal irDevido,
        Statusimp status,
        LocalDateTime dataCriacao
) {
}
