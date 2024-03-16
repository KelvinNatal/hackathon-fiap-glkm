package com.fiap.hackathon.global.relation.reservationadditional.repository;

import com.fiap.hackathon.aditional.projection.AdditionalProjection;
import com.fiap.hackathon.global.relation.reservationadditional.entity.ReservationAdditionalRelation;
import com.fiap.hackathon.global.relation.reservationadditional.pk.ReservationAdditionalPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ReservatonAdditionalRepository extends JpaRepository<ReservationAdditionalRelation, ReservationAdditionalPK> {

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            reservation_id, additional_id
                        FROM
                            reservation_additional
                        WHERE
                            reservation_id = :reservationId
                    """)
    List<ReservationAdditionalRelation> getReservationsAdditional(@Param("reservationId") UUID reservationId);

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            additionals.id, additionals.name, additionals.cost
                        FROM
                            additionals
                        INNER JOIN
                            reservation_additional
                        ON
                            additionals.id = reservation_additional.additional_id
                        WHERE
                            reservation_additional.reservation_id = :reservationId
                    """)
    List<AdditionalProjection> getAllAdditionalsBoundReservation(@Param("reservationId") UUID reservationId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = """
                        DELETE FROM
                            reservation_additional
                        WHERE
                            reservation_id = :reservationId
                    """
    )
    void deleteReservationAdditionalRelationByReservationId(@Param("reservationId") UUID reservationId);
}
