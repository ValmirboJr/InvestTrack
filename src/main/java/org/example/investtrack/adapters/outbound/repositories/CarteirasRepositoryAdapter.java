package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.Domain.model.carteiras.Carteiras;
import org.example.investtrack.Domain.port.out.CarteirasRepositoryPort;
import org.example.investtrack.adapters.outbound.entities.JpaCarteirasEntity;
import org.example.investtrack.adapters.outbound.mapper.CarteirasEntityMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CarteirasRepositoryAdapter implements CarteirasRepositoryPort {

    private final JpaCarteirasRepository jpaCarteirasRepository;

    public CarteirasRepositoryAdapter(JpaCarteirasRepository jpaCarteirasRepository) {
        this.jpaCarteirasRepository = jpaCarteirasRepository;
    }

    @Override
    public Carteiras save(Carteiras carteira) {
        JpaCarteirasEntity entity = CarteirasEntityMapper.toEntity(carteira);
        JpaCarteirasEntity savedEntity = jpaCarteirasRepository.save(entity);
        return CarteirasEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Carteiras> findById(UUID id) {
        return jpaCarteirasRepository.findById(id).map(CarteirasEntityMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        if (jpaCarteirasRepository.existsById(id)) {
            jpaCarteirasRepository.deleteById(id);
        }
    }

    @Override
    public List<Carteiras> findAll() {
        return CarteirasEntityMapper.toDomain(jpaCarteirasRepository.findAll());
    }

    @Override
    public Optional<Carteiras> update(UUID id, Carteiras carteira) {
        return jpaCarteirasRepository.findById(id)
                .map(entity -> {
                    entity.setIdCliente(carteira.getId_cliente());
                    entity.setNome(carteira.getNome());
                    entity.setDescricao(carteira.getDescricao());
                    entity.setAtualizadoEm(LocalDateTime.now());
                    return CarteirasEntityMapper.toDomain(jpaCarteirasRepository.save(entity));
                });
    }
}
