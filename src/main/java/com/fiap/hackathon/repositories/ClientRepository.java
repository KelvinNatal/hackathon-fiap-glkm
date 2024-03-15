package com.fiap.hackathon.repositories;

import com.fiap.hackathon.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Page<ClientEntity> findAll(Pageable pageable);

    boolean existsByCpf(String cpf);

    boolean existsByPassport(String passport);
}
