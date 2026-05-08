package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.model.cliente.Cliente;
import org.example.investtrack.Domain.port.in.ClienteUseCase;
import org.example.investtrack.adapters.inbound.dto.ClienteRequestDTO;
import org.example.investtrack.adapters.inbound.dto.ClienteResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.ClienteDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteRequestDTO payload) {
        Cliente cliente = ClienteDTOMapper.toDomain(payload);
        Cliente clienteCriado = clienteUseCase.create(cliente);
        return new ResponseEntity<>(ClienteDTOMapper.fromDomain(clienteCriado), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscaCliente(@PathVariable UUID id) {
        Optional<Cliente> cliente = clienteUseCase.buscarPorId(id);
        return cliente.map(value -> new ResponseEntity<>(ClienteDTOMapper.fromDomain(value),HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientes() {
        List<Cliente> clientes = clienteUseCase.ListarClientes();
        return new ResponseEntity<>(ClienteDTOMapper.fromDomain(clientes), HttpStatus.OK);
    }
}