package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.operacoes.Operacoes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OperacoesRepositoryPort {
    Operacoes save(Operacoes operacoes);
    Optional<Operacoes> findById(UUID id);
    void deleteById(UUID id);
    List<Operacoes> findAll();
    Optional<Operacoes> update(UUID id, Operacoes operacoes);
    List<Operacoes> findByCarteiraId(UUID idCarteira);
}
