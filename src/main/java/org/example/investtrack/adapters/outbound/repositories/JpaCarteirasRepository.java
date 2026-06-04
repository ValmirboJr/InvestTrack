package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.adapters.outbound.entities.JpaCarteirasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCarteirasRepository extends JpaRepository<JpaCarteirasEntity, UUID> {
}
