package org.example.investtrack.adapters.outbound.mapper;

import org.example.investtrack.Domain.model.posicoes.Posicoes;
import org.example.investtrack.adapters.outbound.entities.JpaPosicoesEntity;

import java.util.List;

public class PosicoesEntityMapper {

    public static Posicoes toDomain(JpaPosicoesEntity entity) {
        return new Posicoes(
                entity.getIdPosicao(),
                entity.getIdCarteira(),
                entity.getTicker(),
                entity.getQuantidade(),
                entity.getPrecoMedio(),
                entity.getAtivo(),
                entity.getAtualizadoEm()
        );
    }

    public static JpaPosicoesEntity toEntity(Posicoes domain) {
        return new JpaPosicoesEntity(
                domain.getId_posicao(),
                domain.getId_carteira(),
                domain.getTicker(),
                domain.getQuantidade(),
                domain.getPrecoMedio(),
                domain.getAtivo(),
                domain.getAtualizadoEm()
        );
    }

    public static List<Posicoes> toDomain(List<JpaPosicoesEntity> entities) {
        return entities.stream()
                .map(PosicoesEntityMapper::toDomain)
                .toList();
    }
}
