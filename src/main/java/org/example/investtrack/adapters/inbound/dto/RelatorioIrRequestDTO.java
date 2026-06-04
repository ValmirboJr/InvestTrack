package org.example.investtrack.adapters.inbound.dto;

import org.example.investtrack.Domain.model.relatorios.Statusimp;

import java.math.BigDecimal;
import java.util.UUID;

public record RelatorioIrRequestDTO(
        UUID id_carteira,
        String competencia,
        BigDecimal resultadoSwingTrade,
        BigDecimal resultadoDayTrade,
        BigDecimal irDevido,
        Statusimp status
) {
}
