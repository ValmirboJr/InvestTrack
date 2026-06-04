package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.model.posicoes.Posicoes;
import org.example.investtrack.Domain.port.in.PosicoesUseCase;
import org.example.investtrack.adapters.inbound.dto.PosicoesRequestDTO;
import org.example.investtrack.adapters.inbound.dto.PosicoesResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.PosicoesDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/posicoes")
public class PosicoesController {

    private final PosicoesUseCase posicoesUseCase;

    public PosicoesController(PosicoesUseCase posicoesUseCase) {
        this.posicoesUseCase = posicoesUseCase;
    }

    @PostMapping
    public ResponseEntity<PosicoesResponseDTO> create(@RequestBody PosicoesRequestDTO payload) {
        Posicoes posicao = PosicoesDTOMapper.toDomain(payload);
        Posicoes posicaoCriada = posicoesUseCase.create(posicao);
        return new ResponseEntity<>(PosicoesDTOMapper.fromDomain(posicaoCriada), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosicoesResponseDTO> buscarPosicao(@PathVariable UUID id) {
        Optional<Posicoes> posicao = posicoesUseCase.buscarPorId(id);
        return posicao.map(value -> new ResponseEntity<>(PosicoesDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<PosicoesResponseDTO>> getAllPosicoes() {
        List<Posicoes> posicoes = posicoesUseCase.listarPosicoes();
        return new ResponseEntity<>(PosicoesDTOMapper.fromDomain(posicoes), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PosicoesResponseDTO> alterar(@PathVariable UUID id, @RequestBody PosicoesRequestDTO payload) {
        Posicoes posicao = PosicoesDTOMapper.toDomain(payload);
        Optional<Posicoes> posicaoAtualizada = posicoesUseCase.alterar(id, posicao);

        return posicaoAtualizada.map(value -> new ResponseEntity<>(PosicoesDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        posicoesUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
