package org.example.investtrack.adapters.inbound.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CarteirasResponseDTO(UUID id_carteira, UUID id_cliente, String nome, String descricao, LocalDateTime data_criacao) {
}
