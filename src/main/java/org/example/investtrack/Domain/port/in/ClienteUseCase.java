package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.cliente.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteUseCase {
    Cliente create(Cliente cliente);
    Optional<Cliente> buscarPorId(UUID id);
    void delete(UUID id);
    Optional<Cliente> alterar(UUID idCliente, Cliente cliente);
    List<Cliente> ListarClientes();
}