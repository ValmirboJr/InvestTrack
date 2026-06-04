package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.cotacoes.Cotacao;
import reactor.core.publisher.Mono;

public interface CotacaoUseCase {
    Mono<Cotacao> buscarCotacao(String ticker);
}
