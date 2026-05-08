package org.example.investtrack.Domain.model.cliente;

import java.time.LocalDateTime;

public record ClienteRequestDTO(String nome, String cpf, String email, LocalDateTime created) {
}
