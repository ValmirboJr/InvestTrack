package org.example.investtrack.adapters.outbound.mapper;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;
import org.example.investtrack.adapters.outbound.entities.JpaRelatorioIrEntity;

import java.time.YearMonth;
import java.util.List;

public class RelatorioIrEntityMapper {

    public static Relatorio_ir toDomain(JpaRelatorioIrEntity entity) {
        return new Relatorio_ir(
                entity.getIdRelatorio(),
                entity.getIdCarteira(),
                YearMonth.parse(entity.getCompetencia()),
                entity.getResultadoSwingTrade(),
                entity.getResultadoDayTrade(),
                entity.getIrDevido(),
                entity.getStatus(),
                entity.getDataCriacao()
        );
    }

    public static JpaRelatorioIrEntity toEntity(Relatorio_ir domain) {
        return new JpaRelatorioIrEntity(
                domain.getId_relatorio(),
                domain.getId_carteira(),
                domain.getCompetencia().toString(),
                domain.getLucroOpc(),
                domain.getLucropDia(),
                domain.getImpDevido(),
                domain.getStatus(),
                domain.getDataCriacao()
        );
    }

    public static List<Relatorio_ir> toDomain(List<JpaRelatorioIrEntity> entities) {
        return entities.stream()
                .map(RelatorioIrEntityMapper::toDomain)
                .toList();
    }
}
