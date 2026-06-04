package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.cotacoes.Cotacao;
import org.example.investtrack.adapters.inbound.dto.CotacaoResponseDTO;

public class CotacaoDTOMapper {

    public static CotacaoResponseDTO fromDomain(Cotacao domain) {
        return new CotacaoResponseDTO(
                domain.getTicker(),
                domain.getPreco(),
                domain.getDataHora()
        );
    }
}
