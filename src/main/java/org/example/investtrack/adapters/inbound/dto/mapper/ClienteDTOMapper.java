package org.example.investtrack.adapters.inbound.dto.mapper;

import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.adapters.inbound.dto.ClienteRequestDTO;
import org.example.investtrack.adapters.inbound.dto.ClienteResponseDTO;

import java.util.List;

public class ClienteDTOMapper {

    public static Cliente toDomain(ClienteRequestDTO request) {
        return Cliente.criar(
                request.nome(),
                request.cpf(),
                request.email(),
                request.data_cadastro()
        );
    }

    public static ClienteResponseDTO fromDomain(Cliente domain) {
        return new ClienteResponseDTO(
                domain.getId(),
                domain.getNome(),
                domain.getCpf(),
                domain.getEmail(),
                domain.getData_cadastro()
        );
    }

    public static List<ClienteResponseDTO> fromDomain(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteDTOMapper::fromDomain)
                .toList();
    }
}