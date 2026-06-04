package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.posicoes.Posicoes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PosicoesRepositoryPort {
    Posicoes save(Posicoes posicao);
    Optional<Posicoes> findById(UUID id);
    void deleteById(UUID id);
    List<Posicoes> findAll();
    Optional<Posicoes> update(UUID id, Posicoes posicao);
}
