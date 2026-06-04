package org.example.investtrack.Domain.model.relatorios;

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

    public Relatorio_ir() {}

    public Relatorio_ir(UUID id_relatorio, UUID id_carteira, YearMonth competencia, BigDecimal lucroOpc, BigDecimal lucropDia, BigDecimal impDevido, Statusimp status, LocalDateTime dataCriacao) {
        this.id_relatorio = id_relatorio;
        this.id_carteira = id_carteira;
        LucroOpc = lucroOpc;
        LucropDia = lucropDia;
        this.competencia = competencia;
        this.impDevido = impDevido;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public UUID getId_relatorio() {
        return id_relatorio;
    }

    public void setId_relatorio(UUID id_relatorio) {
        this.id_relatorio = id_relatorio;
    }

    public UUID getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(UUID id_carteira) {
        this.id_carteira = id_carteira;
    }

    public YearMonth getCompetencia() {
        return competencia;
    }

    public void setCompetencia(YearMonth competencia) {
        this.competencia = competencia;
    }

    public BigDecimal getLucroOpc() {
        return LucroOpc;
    }

    public void setLucroOpc(BigDecimal lucroOpc) {
        LucroOpc = lucroOpc;
    }

    public BigDecimal getLucropDia() {
        return LucropDia;
    }

    public void setLucropDia(BigDecimal lucropDia) {
        LucropDia = lucropDia;
    }

    public BigDecimal getImpDevido() {
        return impDevido;
    }

    public void setImpDevido(BigDecimal impDevido) {
        this.impDevido = impDevido;
    }

    public Statusimp getStatus() {
        return status;
    }

    public void setStatus(Statusimp status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
