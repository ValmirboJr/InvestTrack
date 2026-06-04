package org.example.investtrack.Domain.port.out;

import org.example.investtrack.Domain.model.carteiras.Carteiras;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarteirasRepositoryPort {
    Carteiras save(Carteiras carteira);
    Optional<Carteiras> findById(UUID id);
    void deleteById(UUID id);
    List<Carteiras> findAll();
    Optional<Carteiras> update(UUID id, Carteiras carteira);
}
