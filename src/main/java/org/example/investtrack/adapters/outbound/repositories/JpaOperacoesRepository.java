package org.example.investtrack.adapters.outbound.repositories;

import org.example.investtrack.adapters.outbound.entities.JpaOperacoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaOperacoesRepository extends JpaRepository<JpaOperacoesEntity, UUID> {
    List<JpaOperacoesEntity> findByIdCarteira(UUID idCarteira);
}
