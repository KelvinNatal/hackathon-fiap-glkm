package com.fiap.hackathon.accomodation.repository;


import com.fiap.hackathon.accomodation.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccomodationRepository extends JpaRepository<Accommodation, UUID> {
    Accommodation findByName(String name);
}
