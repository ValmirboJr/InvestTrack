package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.carteiras.Carteiras;
import org.example.investtrack.adapters.inbound.dto.CarteirasRequestDTO;
import org.example.investtrack.adapters.inbound.dto.CarteirasResponseDTO;

import java.util.List;

public class CarteirasDTOMapper {

    public static Carteiras toDomain(CarteirasRequestDTO request) {
        return new Carteiras(
                request.nome(),
                request.descricao(),
                null,
                request.id_cliente(),
                null
        );
    }

    public static CarteirasResponseDTO fromDomain(Carteiras domain) {
        return new CarteirasResponseDTO(
                domain.getId_carteira(),
                domain.getId_cliente(),
                domain.getNome(),
                domain.getDescricao(),
                domain.getData_criacao()
        );
    }

    public static List<CarteirasResponseDTO> fromDomain(List<Carteiras> carteiras) {
        return carteiras.stream()
                .map(CarteirasDTOMapper::fromDomain)
                .toList();
    }
}
