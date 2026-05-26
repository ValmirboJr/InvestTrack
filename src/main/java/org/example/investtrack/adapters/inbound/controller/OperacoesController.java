package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.Domain.port.in.OperacoesUseCase;
import org.example.investtrack.adapters.inbound.dto.OperacoesRequestDTO;
import org.example.investtrack.adapters.inbound.dto.OperacoesResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.OperacoesDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/operacoes")
public class OperacoesController {

    private final OperacoesUseCase operacoesUseCase;

    public OperacoesController(OperacoesUseCase operacoesUseCase) {
        this.operacoesUseCase = operacoesUseCase;
    }

    @PostMapping
    public ResponseEntity<OperacoesResponseDTO> create(@RequestBody OperacoesRequestDTO payload) {
        Operacoes operacoes = OperacoesDTOMapper.toDomain(payload);
        Operacoes operacaoCriada = operacoesUseCase.create(operacoes);
        return new ResponseEntity<>(OperacoesDTOMapper.fromDomain(operacaoCriada), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperacoesResponseDTO> buscarOperacao(@PathVariable UUID id) {
        Optional<Operacoes> operacoes = operacoesUseCase.buscarPorId(id);
        return operacoes.map(value -> new ResponseEntity<>(OperacoesDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<OperacoesResponseDTO>> getAllOperacoes(@RequestParam(required = false) UUID idCarteira) {
        List<Operacoes> operacoes = idCarteira == null
                ? operacoesUseCase.listarOperacoes()
                : operacoesUseCase.listarPorCarteira(idCarteira);

        return new ResponseEntity<>(OperacoesDTOMapper.fromDomain(operacoes), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperacoesResponseDTO> alterar(@PathVariable UUID id, @RequestBody OperacoesRequestDTO payload) {
        Operacoes operacoes = OperacoesDTOMapper.toDomain(payload);
        Optional<Operacoes> operacaoAtualizada = operacoesUseCase.alterar(id, operacoes);

        return operacaoAtualizada.map(value -> new ResponseEntity<>(OperacoesDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        operacoesUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
