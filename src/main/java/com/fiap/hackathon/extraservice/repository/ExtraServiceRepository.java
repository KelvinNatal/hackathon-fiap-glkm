package com.fiap.hackathon.extraservice.repository;

import com.fiap.hackathon.extraservice.entity.ExtraServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ExtraServiceEntity, UUID> {
    Page<ExtraServiceEntity> findAll(Pageable pageable);
}
