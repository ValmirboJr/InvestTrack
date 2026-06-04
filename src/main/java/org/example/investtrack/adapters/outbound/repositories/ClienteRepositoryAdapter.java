package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.Domain.port.out.ClienteRepositoryPort;
import org.example.investtrack.adapters.outbound.entities.JpaClienteEntity;
import org.example.investtrack.adapters.outbound.mapper.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final JpaClienteRespository jpaClienteRespository;

    public ClienteRepositoryAdapter(JpaClienteRespository jpaClienteRespository) {
        this.jpaClienteRespository = jpaClienteRespository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        JpaClienteEntity clienteEntity = ClienteMapper.toEntity(cliente);
        JpaClienteEntity savedClienteEntity = jpaClienteRespository.save(clienteEntity);
        return ClienteMapper.toListarCliente(savedClienteEntity);
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return this.jpaClienteRespository.findById(id).map(ClienteMapper::toListarCliente);
    }

    @Override
    public void deleteById(UUID id) {
        if (this.jpaClienteRespository.existsById(id)) {
            this.jpaClienteRespository.deleteById(id);
        }

    }

    @Override
    public List<Cliente> findAll() {
        return this.jpaClienteRespository.findAll().stream().map(entity-> new Cliente(entity.getId(), entity.getNome(), entity.getCpf(),
                entity.getEmail(), entity.getData_cadastro())).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> update(UUID id, Cliente cliente) {
        if (!jpaClienteRespository.existsById(id)) {
            return Optional.empty();
        }

        JpaClienteEntity clienteEntity = jpaClienteRespository.findById(id).orElseThrow();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setEmail(cliente.getEmail());

        JpaClienteEntity savedClienteEntity = jpaClienteRespository.save(clienteEntity);
        return Optional.of(ClienteMapper.toListarCliente(savedClienteEntity));
    }
}