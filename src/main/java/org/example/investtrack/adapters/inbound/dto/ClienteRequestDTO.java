package org.example.investtrack.adapters.inbound.dto;

import java.time.LocalDateTime;

public record ClienteRequestDTO(String nome, String cpf, String email, LocalDateTime data_cadastro) {
}
