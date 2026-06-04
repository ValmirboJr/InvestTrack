package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.posicoes.Posicoes;
import org.example.investtrack.adapters.inbound.dto.PosicoesRequestDTO;
import org.example.investtrack.adapters.inbound.dto.PosicoesResponseDTO;

import java.util.List;

public class PosicoesDTOMapper {

    public static Posicoes toDomain(PosicoesRequestDTO request) {
        return new Posicoes(
                null,
                request.id_carteira(),
                request.ticker(),
                request.quantidade(),
                request.precoMedio(),
                request.ativo(),
                null
        );
    }

    public static PosicoesResponseDTO fromDomain(Posicoes domain) {
        return new PosicoesResponseDTO(
                domain.getId_posicao(),
                domain.getId_carteira(),
                domain.getTicker(),
                domain.getQuantidade(),
                domain.getPrecoMedio(),
                domain.getAtivo(),
                domain.getAtualizadoEm()
        );
    }

    public static List<PosicoesResponseDTO> fromDomain(List<Posicoes> posicoes) {
        return posicoes.stream()
                .map(PosicoesDTOMapper::fromDomain)
                .toList();
    }
}
