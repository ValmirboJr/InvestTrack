package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;
import org.example.investtrack.Domain.port.out.RelatorioIrRepositoryPort;
import org.example.investtrack.adapters.outbound.entities.JpaRelatorioIrEntity;
import org.example.investtrack.adapters.outbound.mapper.RelatorioIrEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RelatorioIrRepositoryAdapter implements RelatorioIrRepositoryPort {

    private final JpaRelatorioIrRepository jpaRelatorioIrRepository;

    public RelatorioIrRepositoryAdapter(JpaRelatorioIrRepository jpaRelatorioIrRepository) {
        this.jpaRelatorioIrRepository = jpaRelatorioIrRepository;
    }

    @Override
    public Relatorio_ir save(Relatorio_ir relatorio) {
        JpaRelatorioIrEntity entity = RelatorioIrEntityMapper.toEntity(relatorio);
        JpaRelatorioIrEntity savedEntity = jpaRelatorioIrRepository.save(entity);
        return RelatorioIrEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Relatorio_ir> findById(UUID id) {
        return jpaRelatorioIrRepository.findById(id).map(RelatorioIrEntityMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        if (jpaRelatorioIrRepository.existsById(id)) {
            jpaRelatorioIrRepository.deleteById(id);
        }
    }

    @Override
    public List<Relatorio_ir> findAll() {
        return RelatorioIrEntityMapper.toDomain(jpaRelatorioIrRepository.findAll());
    }

    @Override
    public Optional<Relatorio_ir> update(UUID id, Relatorio_ir relatorio) {
        return jpaRelatorioIrRepository.findById(id)
                .map(entity -> {
                    entity.setIdCarteira(relatorio.getId_carteira());
                    entity.setCompetencia(relatorio.getCompetencia().toString());
                    entity.setResultadoSwingTrade(relatorio.getLucroOpc());
                    entity.setResultadoDayTrade(relatorio.getLucropDia());
                    entity.setIrDevido(relatorio.getImpDevido());
                    entity.setStatus(relatorio.getStatus());
                    return RelatorioIrEntityMapper.toDomain(jpaRelatorioIrRepository.save(entity));
                });
    }
}
