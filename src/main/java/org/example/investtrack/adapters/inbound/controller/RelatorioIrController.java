package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.model.relatorios.Relatorio_ir;
import org.example.investtrack.Domain.port.in.RelatorioIrUseCase;
import org.example.investtrack.adapters.inbound.dto.RelatorioIrRequestDTO;
import org.example.investtrack.adapters.inbound.dto.RelatorioIrResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.RelatorioIrDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/apuracoes-ir")
public class RelatorioIrController {

    private final RelatorioIrUseCase relatorioIrUseCase;

    public RelatorioIrController(RelatorioIrUseCase relatorioIrUseCase) {
        this.relatorioIrUseCase = relatorioIrUseCase;
    }

    @PostMapping
    public ResponseEntity<RelatorioIrResponseDTO> create(@RequestBody RelatorioIrRequestDTO payload) {
        Relatorio_ir relatorio = RelatorioIrDTOMapper.toDomain(payload);
        Relatorio_ir relatorioCriado = relatorioIrUseCase.create(relatorio);
        return new ResponseEntity<>(RelatorioIrDTOMapper.fromDomain(relatorioCriado), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatorioIrResponseDTO> buscarRelatorio(@PathVariable UUID id) {
        Optional<Relatorio_ir> relatorio = relatorioIrUseCase.buscarPorId(id);
        return relatorio.map(value -> new ResponseEntity<>(RelatorioIrDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<RelatorioIrResponseDTO>> getAllRelatorios() {
        List<Relatorio_ir> relatorios = relatorioIrUseCase.listarRelatorios();
        return new ResponseEntity<>(RelatorioIrDTOMapper.fromDomain(relatorios), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatorioIrResponseDTO> alterar(@PathVariable UUID id, @RequestBody RelatorioIrRequestDTO payload) {
        Relatorio_ir relatorio = RelatorioIrDTOMapper.toDomain(payload);
        Optional<Relatorio_ir> relatorioAtualizado = relatorioIrUseCase.alterar(id, relatorio);

        return relatorioAtualizado.map(value -> new ResponseEntity<>(RelatorioIrDTOMapper.fromDomain(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        relatorioIrUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
