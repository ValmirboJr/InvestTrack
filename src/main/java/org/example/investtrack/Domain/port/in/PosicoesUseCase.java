package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.posicoes.Posicoes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PosicoesUseCase {
    Posicoes create(Posicoes posicao);
    Optional<Posicoes> buscarPorId(UUID id);
    void delete(UUID id);
    Optional<Posicoes> alterar(UUID idPosicao, Posicoes posicao);
    List<Posicoes> listarPosicoes();
}
