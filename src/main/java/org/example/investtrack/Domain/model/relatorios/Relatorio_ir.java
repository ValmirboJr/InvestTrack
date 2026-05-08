package org.example.investtrack.Domain.entity.relatorios;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.UUID;

public class Relatorio_ir {

    private UUID id_relatorio;
    private UUID id_carteira;
    private YearMonth competencia;
    private BigDecimal LucroOpc;
    private BigDecimal LucropDia;
    private BigDecimal impDevido;
    private Statusimp status;
    private LocalDateTime dataCriacao;
}
