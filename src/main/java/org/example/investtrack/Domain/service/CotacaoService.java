package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.cotacoes.Cotacao;
import org.example.investtrack.Domain.port.in.CotacaoUseCase;
import org.example.investtrack.Domain.port.out.CotacaoPort;
import reactor.core.publisher.Mono;

public class CotacaoService implements CotacaoUseCase {

    private final CotacaoPort cotacaoPort;

    public CotacaoService(CotacaoPort cotacaoPort) {
        this.cotacaoPort = cotacaoPort;
    }

    @Override
    public Mono<Cotacao> buscarCotacao(String ticker) {
        return cotacaoPort.buscarCotacao(ticker.toUpperCase());
    }
}
