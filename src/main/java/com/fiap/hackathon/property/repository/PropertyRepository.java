package com.fiap.hackathon.property.repository;

import com.fiap.hackathon.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
    Property findByName(String name);
}
