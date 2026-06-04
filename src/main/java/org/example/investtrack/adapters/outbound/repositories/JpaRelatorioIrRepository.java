package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.adapters.outbound.entities.JpaRelatorioIrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRelatorioIrRepository extends JpaRepository<JpaRelatorioIrEntity, UUID> {
}
