package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.Domain.port.in.OperacoesUseCase;
import org.example.investtrack.Domain.port.out.OperacoesRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OperacoesService implements OperacoesUseCase {

    private final OperacoesRepositoryPort repository;

    public OperacoesService(OperacoesRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Operacoes create(Operacoes operacoes) {
        if (operacoes.getId_operacao() == null) {
            operacoes.setId_operacao(UUID.randomUUID());
        }

        if (operacoes.getDataCriacao() == null) {
            operacoes.setDataCriacao(LocalDateTime.now());
        }

        return repository.save(operacoes);
    }

    @Override
    public Optional<Operacoes> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Operacoes> alterar(UUID idOperacao, Operacoes operacoes) {
        return repository.update(idOperacao, operacoes);
    }

    @Override
    public List<Operacoes> listarOperacoes() {
        return repository.findAll();
    }

    @Override
    public List<Operacoes> listarPorCarteira(UUID idCarteira) {
        return repository.findByCarteiraId(idCarteira);
    }
}
