package org.example.investtrack.adapters.inbound.controller;

import org.example.investtrack.Domain.port.in.CotacaoUseCase;
import org.example.investtrack.adapters.inbound.dto.CotacaoResponseDTO;
import org.example.investtrack.adapters.inbound.dto.mapper.CotacaoDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cotacoes")
public class CotacaoController {

    private final CotacaoUseCase cotacaoUseCase;

    public CotacaoController(CotacaoUseCase cotacaoUseCase) {
        this.cotacaoUseCase = cotacaoUseCase;
    }

    @GetMapping("/{ticker}")
    public Mono<ResponseEntity<CotacaoResponseDTO>> buscarCotacao(@PathVariable String ticker) {
        return cotacaoUseCase.buscarCotacao(ticker)
                .map(CotacaoDTOMapper::fromDomain)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
