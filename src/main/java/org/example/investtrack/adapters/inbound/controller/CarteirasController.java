package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.model.carteiras.Carteiras;
import org.example.investtrack.Domain.port.in.CarteirasUseCase;
import org.example.investtrack.adapters.inbound.dto.CarteirasRequestDTO;
import org.example.investtrack.adapters.inbound.dto.CarteirasResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.CarteirasDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/carteiras")
public class CarteirasController {

    private final CarteirasUseCase carteirasUseCase;

    public CarteirasController(CarteirasUseCase carteirasUseCase) {
        this.carteirasUseCase = carteirasUseCase;
    }

    @PostMapping
    public ResponseEntity<CarteirasResponseDTO> create(@RequestBody CarteirasRequestDTO payload) {
        Carteiras carteira = CarteirasDTOMapper.toDomain(payload);
        Carteiras carteiraCriada = carteirasUseCase.create(carteira);
        return new ResponseEntity<>(CarteirasDTOMapper.fromDomain(carteiraCriada), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteirasResponseDTO> buscarCarteira(@PathVariable UUID id) {
        Optional<Carteiras> carteira = carteirasUseCase.buscarPorId(id);
        return carteira.map(value -> new ResponseEntity<>(CarteirasDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<CarteirasResponseDTO>> getAllCarteiras() {
        List<Carteiras> carteiras = carteirasUseCase.listarCarteiras();
        return new ResponseEntity<>(CarteirasDTOMapper.fromDomain(carteiras), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarteirasResponseDTO> alterar(@PathVariable UUID id, @RequestBody CarteirasRequestDTO payload) {
        Carteiras carteira = CarteirasDTOMapper.toDomain(payload);
        Optional<Carteiras> carteiraAtualizada = carteirasUseCase.alterar(id, carteira);

        return carteiraAtualizada.map(value -> new ResponseEntity<>(CarteirasDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carteirasUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
