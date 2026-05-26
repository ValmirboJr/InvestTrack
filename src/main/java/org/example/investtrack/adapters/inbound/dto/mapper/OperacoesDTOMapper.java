package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.adapters.inbound.dto.OperacoesRequestDTO;
import org.example.investtrack.adapters.inbound.dto.OperacoesResponseDTO;

import java.util.List;

public class OperacoesDTOMapper {

    public static Operacoes toDomain(OperacoesRequestDTO request) {
        return new Operacoes(
                null,
                request.id_carteira(),
                request.ticker(),
                request.tipo(),
                request.quantidade(),
                request.precoUnitario(),
                request.dataOpc(),
                null
        );
    }

    public static OperacoesResponseDTO fromDomain(Operacoes domain) {
        return new OperacoesResponseDTO(
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

    public static List<OperacoesResponseDTO> fromDomain(List<Operacoes> operacoes) {
        return operacoes.stream()
                .map(OperacoesDTOMapper::fromDomain)
                .toList();
    }
}