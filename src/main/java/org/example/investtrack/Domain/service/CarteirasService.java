package org.example.investtrack.Domain.service;

import org.example.investtrack.Domain.model.carteiras.Carteiras;
import org.example.investtrack.Domain.port.in.CarteirasUseCase;
import org.example.investtrack.Domain.port.out.CarteirasRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarteirasService implements CarteirasUseCase {

    private final CarteirasRepositoryPort repository;

    public CarteirasService(CarteirasRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Carteiras create(Carteiras carteira) {
        if (carteira.getId_carteira() == null) {
            carteira.setId_carteira(UUID.randomUUID());
        }
        if (carteira.getData_criacao() == null) {
            carteira.setData_criacao(LocalDateTime.now());
        }
        return repository.save(carteira);
    }

    @Override
    public Optional<Carteiras> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Carteiras> alterar(UUID idCarteira, Carteiras carteira) {
        return repository.update(idCarteira, carteira);
    }

    @Override
    public List<Carteiras> listarCarteiras() {
        return repository.findAll();
    }
}
