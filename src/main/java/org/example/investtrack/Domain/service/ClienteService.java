package org.example.investtrack.config.service;

import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.Domain.port.out.ClienteRepositoryPort;
import org.example.investtrack.Domain.port.in.ClienteUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class ClienteService implements ClienteUseCase {

    private final ClienteRepositoryPort repository;

    public ClienteService(ClienteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
    this.repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> alterar(UUID idCliente, Cliente cliente) {
        return repository.update(idCliente, cliente);
    }


    @Override
    public List<Cliente> ListarClientes() {
        return repository.findAll();
    }
}
