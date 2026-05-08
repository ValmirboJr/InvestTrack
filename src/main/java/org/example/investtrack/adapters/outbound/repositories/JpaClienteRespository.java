package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.adapters.outbound.entities.JpaClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaClienteRespository extends JpaRepository<JpaClienteEntity, UUID> {
}
