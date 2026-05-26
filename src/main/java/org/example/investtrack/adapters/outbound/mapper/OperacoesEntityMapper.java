package org.example.investtrack.adapters.outbound.mapper;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.adapters.outbound.entities.JpaOperacoesEntity;

import java.util.List;

public class OperacoesEntityMapper {

    public static Operacoes toDomain(JpaOperacoesEntity entity) {
        return new Operacoes(
                entity.getId_operacao(),
                entity.getId_carteira(),
                entity.getTicker(),
                entity.getTipo(),
                entity.getQuantidade(),
                entity.getPrecoUnitario(),
                entity.getDataOpc(),
                entity.getDataCriacao()
        );
    }

    public static JpaOperacoesEntity toEntity(Operacoes domain) {
        return new JpaOperacoesEntity(
                domain.getId_operacao(),
                domain.getId_carteira(),
                domain.getTicker(),
                domain.getTipo(),
                domain.getQuantidade(),
                domain.getPrecoUnitario(),
                domain.getDataOpc(),
                domain.getDataCriacao()
        );
    }

    public static List<Operacoes> toDomain(List<JpaOperacoesEntity> entities) {
        return entities.stream()
                .map(OperacoesEntityMapper::toDomain)
                .toList();
    }
}
