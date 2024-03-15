package com.fiap.hackathon.global.relation.reservationadditional.repository;

import com.fiap.hackathon.global.relation.reservationadditional.entity.ReservationAdditionalRelation;
import com.fiap.hackathon.global.relation.reservationadditional.pk.ReservationAdditionalPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatonAdditionalRepository extends JpaRepository<ReservationAdditionalRelation, ReservationAdditionalPK> {
}
