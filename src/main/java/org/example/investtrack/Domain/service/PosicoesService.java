package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.posicoes.Posicoes;
import org.example.investtrack.Domain.port.in.PosicoesUseCase;
import org.example.investtrack.Domain.port.out.PosicoesRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PosicoesService implements PosicoesUseCase {

    private final PosicoesRepositoryPort repository;

    public PosicoesService(PosicoesRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Posicoes create(Posicoes posicao) {
        if (posicao.getId_posicao() == null) {
            posicao.setId_posicao(UUID.randomUUID());
        }

        if (posicao.getAtualizadoEm() == null) {
            posicao.setAtualizadoEm(LocalDateTime.now());
        }

        return repository.save(posicao);
    }

    @Override
    public Optional<Posicoes> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Posicoes> alterar(UUID idPosicao, Posicoes posicao) {
        posicao.setAtualizadoEm(LocalDateTime.now());
        return repository.update(idPosicao, posicao);
    }

    @Override
    public List<Posicoes> listarPosicoes() {
        return repository.findAll();
    }
}
