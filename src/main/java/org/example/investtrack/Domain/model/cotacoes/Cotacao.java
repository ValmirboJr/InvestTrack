package org.example.investtrack.Domain.model.cotacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cotacao {

    private String ticker;
    private BigDecimal preco;
    private LocalDateTime dataHora;

    public Cotacao() {}

    public Cotacao(String ticker, BigDecimal preco, LocalDateTime dataHora) {
        this.ticker = ticker;
        this.preco = preco;
        this.dataHora = dataHora;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
