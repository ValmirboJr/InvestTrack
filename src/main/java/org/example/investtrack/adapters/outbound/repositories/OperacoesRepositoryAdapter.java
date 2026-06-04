package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.Domain.port.out.OperacoesRepositoryPort;
import org.example.investtrack.adapters.outbound.entities.JpaOperacoesEntity;
import org.example.investtrack.adapters.outbound.mapper.OperacoesEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OperacoesRepositoryAdapter implements OperacoesRepositoryPort {

    private final JpaOperacoesRepository jpaOperacoesRepository;

    public OperacoesRepositoryAdapter(JpaOperacoesRepository jpaOperacoesRepository) {
        this.jpaOperacoesRepository = jpaOperacoesRepository;
    }

    @Override
    public Operacoes save(Operacoes operacoes) {
        JpaOperacoesEntity entity = OperacoesEntityMapper.toEntity(operacoes);
        JpaOperacoesEntity savedEntity = jpaOperacoesRepository.save(entity);
        return OperacoesEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Operacoes> findById(UUID id) {
        return jpaOperacoesRepository.findById(id).map(OperacoesEntityMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        if (jpaOperacoesRepository.existsById(id)) {
            jpaOperacoesRepository.deleteById(id);
        }
    }

    @Override
    public List<Operacoes> findAll() {
        return OperacoesEntityMapper.toDomain(jpaOperacoesRepository.findAll());
    }

    @Override
    public Optional<Operacoes> update(UUID id, Operacoes operacoes) {
        return jpaOperacoesRepository.findById(id)
                .map(entity -> {
                    entity.setIdCarteira(operacoes.getId_carteira());
                    entity.setTicker(operacoes.getTicker());
                    entity.setTipo(operacoes.getTipo());
                    entity.setQuantidade(operacoes.getQuantidade());
                    entity.setPrecoUnitario(operacoes.getPrecoUnitario());
                    entity.setDataOpc(operacoes.getDataOpc());
                    return OperacoesEntityMapper.toDomain(jpaOperacoesRepository.save(entity));
                });
    }

    @Override
    public List<Operacoes> findByCarteiraId(UUID idCarteira) {
        return OperacoesEntityMapper.toDomain(jpaOperacoesRepository.findByIdCarteira(idCarteira));
    }
}
