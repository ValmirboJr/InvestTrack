package org.example.investtrack.adapters.inbound.dto;

import org.example.investtrack.Domain.model.posicoes.Ativo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PosicoesResponseDTO(UUID id_posicao, UUID id_carteira, String ticker, int quantidade, BigDecimal precoMedio, Ativo ativo, LocalDateTime atualizadoEm) {
}
