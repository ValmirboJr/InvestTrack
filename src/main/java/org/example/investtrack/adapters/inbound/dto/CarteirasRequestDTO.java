package org.example.investtrack.adapters.inbound.dto;

import java.util.UUID;

public record CarteirasRequestDTO(String nome, String descricao, UUID id_cliente) {
}
