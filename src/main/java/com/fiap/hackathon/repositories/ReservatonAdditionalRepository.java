package com.fiap.hackathon.repositories;

import com.fiap.hackathon.entities.ReservationAdditionalRelation;
import com.fiap.hackathon.pks.ReservationAdditionalPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatonAdditionalRepository extends JpaRepository<ReservationAdditionalRelation, ReservationAdditionalPK> {
}
