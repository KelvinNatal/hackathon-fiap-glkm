package com.fiap.hackathon.repositories;

import com.fiap.hackathon.entities.ExtraServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ExtraServiceEntity, UUID> {
    Page<ExtraServiceEntity> findAll(Pageable pageable);
}
