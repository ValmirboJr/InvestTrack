package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.cotacoes.Cotacao;
import reactor.core.publisher.Mono;

public interface CotacaoPort {
    Mono<Cotacao> buscarCotacao(String ticker);
}
