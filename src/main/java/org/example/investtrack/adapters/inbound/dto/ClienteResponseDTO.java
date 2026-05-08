package org.example.investtrack.Domain.model.cliente;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClienteResponseDTO(UUID id, String nome, String cpf, String email, LocalDateTime created) {
}
