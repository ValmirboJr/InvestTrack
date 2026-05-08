package org.example.investtrack.adapters.inbound.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClienteResponseDTO(UUID id, String nome, String cpf, String email, LocalDateTime created) {
}
