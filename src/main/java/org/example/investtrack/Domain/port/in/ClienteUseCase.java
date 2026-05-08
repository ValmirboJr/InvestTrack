package org.example.investtrack.config.usecases;

import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.Domain.model.cliente.ClienteRequestDTO;
import org.example.investtrack.Domain.model.cliente.ClienteResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteUseCase {
    Cliente create(ClienteRequestDTO request);
    List<ClienteResponseDTO> buscarPorId(UUID id);
    void delete(UUID id);
    Cliente alterar(UUID idCliente, Cliente cliente);
    void deleteCliente(UUID idCliente);
}