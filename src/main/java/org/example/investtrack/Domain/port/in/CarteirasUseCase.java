package org.example.investtrack.Domain.port.in;

import org.example.investtrack.Domain.model.carteiras.Carteiras;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarteirasUseCase {
    Carteiras create(Carteiras carteira);
    Optional<Carteiras> buscarPorId(UUID id);
    void delete(UUID id);
    Optional<Carteiras> alterar(UUID idCarteira, Carteiras carteira);
    List<Carteiras> listarCarteiras();
}
