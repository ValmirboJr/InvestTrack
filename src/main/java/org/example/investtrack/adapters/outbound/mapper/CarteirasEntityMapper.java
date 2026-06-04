package org.example.investtrack.adapters.outbound.mapper;

import org.example.investtrack.Domain.model.carteiras.Carteiras;
import org.example.investtrack.adapters.outbound.entities.JpaCarteirasEntity;

import java.time.LocalDateTime;
import java.util.List;

public class CarteirasEntityMapper {

    public static Carteiras toDomain(JpaCarteirasEntity entity) {
        return new Carteiras(
                entity.getNome(),
                entity.getDescricao(),
                entity.getIdCarteira(),
                entity.getIdCliente(),
                entity.getDataCriacao()
        );
    }

    public static JpaCarteirasEntity toEntity(Carteiras domain) {
        return new JpaCarteirasEntity(
                domain.getId_carteira(),
                domain.getId_cliente(),
                domain.getNome(),
                domain.getDescricao(),
                domain.getData_criacao(),
                LocalDateTime.now()
        );
    }

    public static List<Carteiras> toDomain(List<JpaCarteirasEntity> entities) {
        return entities.stream()
                .map(CarteirasEntityMapper::toDomain)
                .toList();
    }
}
