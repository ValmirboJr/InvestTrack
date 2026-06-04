package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.Domain.model.posicoes.Posicoes;
import org.example.investtrack.Domain.port.out.PosicoesRepositoryPort;
import org.example.investtrack.adapters.outbound.entities.JpaPosicoesEntity;
import org.example.investtrack.adapters.outbound.mapper.PosicoesEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PosicoesRepositoryAdapter implements PosicoesRepositoryPort {

    private final JpaPosicoesRepository jpaPosicoesRepository;

    public PosicoesRepositoryAdapter(JpaPosicoesRepository jpaPosicoesRepository) {
        this.jpaPosicoesRepository = jpaPosicoesRepository;
    }

    @Override
    public Posicoes save(Posicoes posicao) {
        JpaPosicoesEntity entity = PosicoesEntityMapper.toEntity(posicao);
        JpaPosicoesEntity savedEntity = jpaPosicoesRepository.save(entity);
        return PosicoesEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Posicoes> findById(UUID id) {
        return jpaPosicoesRepository.findById(id).map(PosicoesEntityMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        if (jpaPosicoesRepository.existsById(id)) {
            jpaPosicoesRepository.deleteById(id);
        }
    }

    @Override
    public List<Posicoes> findAll() {
        return PosicoesEntityMapper.toDomain(jpaPosicoesRepository.findAll());
    }

    @Override
    public Optional<Posicoes> update(UUID id, Posicoes posicao) {
        return jpaPosicoesRepository.findById(id)
                .map(entity -> {
                    entity.setIdCarteira(posicao.getId_carteira());
                    entity.setTicker(posicao.getTicker());
                    entity.setQuantidade(posicao.getQuantidade());
                    entity.setPrecoMedio(posicao.getPrecoMedio());
                    entity.setAtivo(posicao.getAtivo());
                    entity.setAtualizadoEm(posicao.getAtualizadoEm());
                    return PosicoesEntityMapper.toDomain(jpaPosicoesRepository.save(entity));
                });
    }
}
