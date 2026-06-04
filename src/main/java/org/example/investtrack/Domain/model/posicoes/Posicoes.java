package org.example.investtrack.Domain.model.posicoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Posicoes {

    private UUID id_posicao;
    private UUID id_carteira;
    private String ticker;
    private int quantidade;
    private BigDecimal precoMedio;
    private Ativo ativo;
    private LocalDateTime atualizadoEm;

    public Posicoes() {}

    public Posicoes(UUID id_posicao, UUID id_carteira, String ticker, int quantidade, BigDecimal precoMedio, Ativo ativo, LocalDateTime atualizadoEm) {
        this.id_posicao = id_posicao;
        this.id_carteira = id_carteira;
        this.ticker = ticker;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
        this.ativo = ativo;
        this.atualizadoEm = atualizadoEm;
    }

    public UUID getId_posicao() {
        return id_posicao;
    }

    public void setId_posicao(UUID id_posicao) {
        this.id_posicao = id_posicao;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(BigDecimal precoMedio) {
        this.precoMedio = precoMedio;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
