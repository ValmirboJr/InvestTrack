package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.operacoes.Operacoes;
import org.example.investtrack.Domain.model.operacoes.Tipo;
import org.example.investtrack.Domain.port.out.OperacoesRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OperacoesServiceTest {

    private OperacoesRepositoryPort repository;
    private OperacoesService service;

    @BeforeEach
    void setUp() {
        repository = mock(OperacoesRepositoryPort.class);
        service = new OperacoesService(repository);
    }

    @Test
    void createComDadosNaoInformados() {
        Operacoes operacao = novaOperacao(null);
        operacao.setDataCriacao(null);
        when(repository.save(any(Operacoes.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Operacoes resultado = service.create(operacao);
        assertThat(resultado.getId_operacao()).isNotNull();
        assertThat(resultado.getDataCriacao()).isNotNull();
        verify(repository).save(operacao);
    }

    @Test
    void buscarPorId() {
        UUID id = UUID.randomUUID();
        Operacoes operacao = novaOperacao(id);
        when(repository.findById(id)).thenReturn(Optional.of(operacao));
        Optional<Operacoes> resultado = service.buscarPorId(id);
        assertThat(resultado).contains(operacao);
        verify(repository).findById(id);
    }

    @Test
    void listarOperacoes() {
        Operacoes operacao = novaOperacao(UUID.randomUUID());
        when(repository.findAll()).thenReturn(List.of(operacao));
        List<Operacoes> resultado = service.listarOperacoes();
        assertThat(resultado).containsExactly(operacao);
        verify(repository).findAll();
    }

    @Test
    void alterar() {
        UUID id = UUID.randomUUID();
        Operacoes operacao = novaOperacao(id);
        when(repository.update(id, operacao)).thenReturn(Optional.of(operacao));
        Optional<Operacoes> resultado = service.alterar(id, operacao);
        assertThat(resultado).contains(operacao);
        verify(repository).update(id, operacao);
    }

    @Test
    void delete() {
        UUID id = UUID.randomUUID();
        service.delete(id);
        verify(repository).deleteById(id);
    }

    @Test
    void listarPorCarteira() {
        UUID idCarteira = UUID.randomUUID();
        Operacoes operacao = novaOperacao(UUID.randomUUID());
        when(repository.findByCarteiraId(idCarteira)).thenReturn(List.of(operacao));
        List<Operacoes> resultado = service.listarPorCarteira(idCarteira);
        assertThat(resultado).containsExactly(operacao);
        verify(repository).findByCarteiraId(idCarteira);
    }

    private Operacoes novaOperacao(UUID id) {
        return new Operacoes(
                id,
                UUID.randomUUID(),
                "PETR4",
                Tipo.COMPRA,
                100,
                new BigDecimal("32.45"),
                Date.valueOf("2026-05-26"),
                LocalDateTime.of(2026, 5, 26, 12, 0)
        );
    }
}