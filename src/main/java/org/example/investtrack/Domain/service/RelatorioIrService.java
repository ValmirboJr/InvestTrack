package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;
import org.example.investtrack.Domain.port.in.RelatorioIrUseCase;
import org.example.investtrack.Domain.port.out.RelatorioIrRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RelatorioIrService implements RelatorioIrUseCase {

    private final RelatorioIrRepositoryPort repository;

    public RelatorioIrService(RelatorioIrRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Relatorio_ir create(Relatorio_ir relatorio) {
        if (relatorio.getId_relatorio() == null) {
            relatorio.setId_relatorio(UUID.randomUUID());
        }

        if (relatorio.getDataCriacao() == null) {
            relatorio.setDataCriacao(LocalDateTime.now());
        }

        return repository.save(relatorio);
    }

    @Override
    public Optional<Relatorio_ir> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Relatorio_ir> alterar(UUID idRelatorio, Relatorio_ir relatorio) {
        return repository.update(idRelatorio, relatorio);
    }

    @Override
    public List<Relatorio_ir> listarRelatorios() {
        return repository.findAll();
    }
}
