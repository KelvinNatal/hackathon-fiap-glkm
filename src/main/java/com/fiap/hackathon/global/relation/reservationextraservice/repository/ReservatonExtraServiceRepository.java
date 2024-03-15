package com.fiap.hackathon.global.relation.reservationextraservice.repository;

import com.fiap.hackathon.global.relation.reservationextraservice.entity.ReservationExtraServiceRelation;
import com.fiap.hackathon.global.relation.reservationextraservice.pk.ReservationExtraServicePK;
import com.fiap.hackathon.global.relation.reservationextraservice.projection.ExtraServiceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ReservatonExtraServiceRepository extends JpaRepository<ReservationExtraServiceRelation, ReservationExtraServicePK> {

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            reservation_id, extra_service_id
                        FROM
                            reservation_extra_service
                        WHERE
                            reservation_id = :reservationId
                    """)
    List<ReservationExtraServiceRelation> getReservationsService(@Param("reservationId") UUID reservationId);

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            extra_services.id, extra_services.name, extra_services.cost
                        FROM
                            extra_services
                        INNER JOIN
                            reservation_extra_service
                        ON
                            extra_services.id = reservation_extra_service.extra_service_id
                        WHERE
                            reservation_extra_service.reservation_id = :reservationId
                    """)
    List<ExtraServiceProjection> getAllExtraServicesBoundReservation(@Param("reservationId") UUID reservationId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = """
                        DELETE FROM
                            reservation_extra_service
                        WHERE
                            reservation_id = :reservationId
                    """
    )
    void deleteReservationExtraServiceRelationByReservationId(@Param("reservationId") UUID reservationId);
}
