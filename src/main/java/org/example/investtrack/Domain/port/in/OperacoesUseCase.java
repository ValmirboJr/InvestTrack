package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.operacoes.Operacoes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OperacoesUseCase {
    Operacoes create(Operacoes operacoes);
    Optional<Operacoes> buscarPorId(UUID id);
    void delete(UUID id);
    Optional<Operacoes> alterar(UUID idOperacao, Operacoes operacoes);
    List<Operacoes> listarOperacoes();
    List<Operacoes> listarPorCarteira(UUID idCarteira);
}
