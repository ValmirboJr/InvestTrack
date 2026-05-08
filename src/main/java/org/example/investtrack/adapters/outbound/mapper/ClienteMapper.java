package org.example.investtrack.adapters.outbound.mapper;


import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.adapters.inbound.dto.ClienteResponseDTO;
import org.example.investtrack.adapters.outbound.entities.JpaClienteEntity;

import java.util.List;

public class ClienteMapper {

    public static Cliente toListarCliente(JpaClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getData_cadastro()
        );
    }

    public static JpaClienteEntity toEntity(Cliente domain) {
        return new JpaClienteEntity(
                domain.getId(),
                domain.getNome(),
                domain.getCpf(),
                domain.getEmail(),
                domain.getData_cadastro()
        );
    }


    public static List<Cliente> toListarCliente(List<JpaClienteEntity> entities) {
        return entities.stream()
                .map(ClienteMapper::toListarCliente)
                .toList();
    }
}