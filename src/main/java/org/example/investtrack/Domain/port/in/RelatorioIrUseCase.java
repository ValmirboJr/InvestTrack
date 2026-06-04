package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RelatorioIrUseCase {
    Relatorio_ir create(Relatorio_ir relatorio);
    Optional<Relatorio_ir> buscarPorId(UUID id);
    void delete(UUID id);
    Optional<Relatorio_ir> alterar(UUID idRelatorio, Relatorio_ir relatorio);
    List<Relatorio_ir> listarRelatorios();
}
