package org.example.investtrack.Domain.model.operacoes;

import java.math.BigDecimal;
import java.sql.Date;

import java.time.LocalDateTime;
import java.util.UUID;

public class Operacoes {

    private UUID id_operacao;
    private UUID id_carteira;
    private String ticker;
    private Tipo tipo;
    private int quantidade;
    private BigDecimal precoUnitario;
    private Date dataOpc;
    private LocalDateTime dataCriacao;

    public Operacoes() {}

    public Operacoes(UUID id_operacao, UUID id_carteira, String ticker, Tipo tipo, int quantidade, BigDecimal precoUnitario, Date dataOpc, LocalDateTime dataCriacao) {
        this.id_operacao = id_operacao;
        this.id_carteira = id_carteira;
        this.ticker = ticker;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.dataOpc = dataOpc;
        this.dataCriacao = dataCriacao;
    }

    public UUID getId_operacao() {
        return id_operacao;
    }

    public void setId_operacao(UUID id_operacao) {
        this.id_operacao = id_operacao;
    }

    public UUID getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(UUID id_carteira) {
        this.id_carteira = id_carteira;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Date getDataOpc() {
        return dataOpc;
    }

    public void setDataOpc(Date dataOpc) {
        this.dataOpc = dataOpc;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
