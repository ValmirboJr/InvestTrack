package org.example.investtrack.config;

import org.example.investtrack.Domain.port.in.CarteirasUseCase;
import org.example.investtrack.Domain.port.in.CotacaoUseCase;
import org.example.investtrack.Domain.port.out.ClienteRepositoryPort;
import org.example.investtrack.Domain.port.out.CarteirasRepositoryPort;
import org.example.investtrack.Domain.port.out.CotacaoPort;
import org.example.investtrack.Domain.port.out.OperacoesRepositoryPort;
import org.example.investtrack.Domain.port.out.PosicoesRepositoryPort;
import org.example.investtrack.Domain.port.out.RelatorioIrRepositoryPort;
import org.example.investtrack.Domain.service.CarteirasService;
import org.example.investtrack.Domain.service.ClienteService;
import org.example.investtrack.Domain.service.CotacaoService;
import org.example.investtrack.Domain.port.in.ClienteUseCase;
import org.example.investtrack.Domain.port.in.OperacoesUseCase;
import org.example.investtrack.Domain.port.in.PosicoesUseCase;
import org.example.investtrack.Domain.port.in.RelatorioIrUseCase;
import org.example.investtrack.Domain.service.OperacoesService;
import org.example.investtrack.Domain.service.PosicoesService;
import org.example.investtrack.Domain.service.RelatorioIrService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Aqui vão as beans do UseCases

@Configuration
public class AppConfig {

    @Bean
    public ClienteUseCase clienteUseCase(ClienteRepositoryPort clienteRepositoryPort){
        return new ClienteService(clienteRepositoryPort);
    }

    @Bean
    public OperacoesUseCase operacoesUseCase(OperacoesRepositoryPort operacoesRepositoryPort) {
        return new OperacoesService(operacoesRepositoryPort);
    }

    @Bean
    public CarteirasUseCase carteirasUseCase(CarteirasRepositoryPort carteirasRepositoryPort) {
        return new CarteirasService(carteirasRepositoryPort);
    }

    @Bean
    public PosicoesUseCase posicoesUseCase(PosicoesRepositoryPort posicoesRepositoryPort) {
        return new PosicoesService(posicoesRepositoryPort);
    }

    @Bean
    public RelatorioIrUseCase relatorioIrUseCase(RelatorioIrRepositoryPort relatorioIrRepositoryPort) {
        return new RelatorioIrService(relatorioIrRepositoryPort);
    }

    @Bean
    public CotacaoUseCase cotacaoUseCase(CotacaoPort cotacaoPort) {
        return new CotacaoService(cotacaoPort);
    }
}
