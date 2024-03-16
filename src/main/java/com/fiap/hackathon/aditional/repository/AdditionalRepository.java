package com.fiap.hackathon.aditional.repository;


import com.fiap.hackathon.aditional.entity.AdditionalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdditionalRepository extends JpaRepository<AdditionalEntity, UUID> {

    Page<AdditionalEntity> findAll(Pageable pageable);
}
