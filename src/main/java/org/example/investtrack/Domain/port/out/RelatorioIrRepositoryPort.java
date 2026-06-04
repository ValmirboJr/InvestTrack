package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RelatorioIrRepositoryPort {
    Relatorio_ir save(Relatorio_ir relatorio);
    Optional<Relatorio_ir> findById(UUID id);
    void deleteById(UUID id);
    List<Relatorio_ir> findAll();
    Optional<Relatorio_ir> update(UUID id, Relatorio_ir relatorio);
}
