package com.fiap.hackathon.repositories;


import com.fiap.hackathon.entities.AdditionalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdditionalRepository extends JpaRepository<AdditionalEntity, UUID> {

    Page<AdditionalEntity> findAll(Pageable pageable);
    AdditionalEntity findByIdAdditional(UUID id);

    boolean existsByIdAdditional (UUID id);


    void deleteByIdAdditional(UUID id);
}

