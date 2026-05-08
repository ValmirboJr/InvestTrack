package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.cliente.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(UUID id);
    void deleteById(UUID id);
    List<Cliente> findAll();
    Optional<Cliente> update(UUID id, Cliente cliente);
}