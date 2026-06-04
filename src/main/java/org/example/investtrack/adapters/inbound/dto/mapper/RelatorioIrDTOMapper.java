package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;
import org.example.investtrack.adapters.inbound.dto.RelatorioIrRequestDTO;
import org.example.investtrack.adapters.inbound.dto.RelatorioIrResponseDTO;

import java.time.YearMonth;
import java.util.List;

public class RelatorioIrDTOMapper {

    public static Relatorio_ir toDomain(RelatorioIrRequestDTO request) {
        return new Relatorio_ir(
                null,
                request.id_carteira(),
                YearMonth.parse(request.competencia()),
                request.resultadoSwingTrade(),
                request.resultadoDayTrade(),
                request.irDevido(),
                request.status(),
                null
        );
    }

    public static RelatorioIrResponseDTO fromDomain(Relatorio_ir domain) {
        return new RelatorioIrResponseDTO(
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

    public static List<RelatorioIrResponseDTO> fromDomain(List<Relatorio_ir> relatorios) {
        return relatorios.stream()
                .map(RelatorioIrDTOMapper::fromDomain)
                .toList();
    }
}
