package org.example.investtrack.adapters.inbound.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CotacaoResponseDTO(String ticker, BigDecimal preco, LocalDateTime dataHora) {
}
