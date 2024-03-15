package com.fiap.hackathon.repositories;

import com.fiap.hackathon.entities.ReservationExtraServiceRelation;
import com.fiap.hackathon.pks.ReservationExtraServicePK;
import com.fiap.hackathon.projection.ExtraServiceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReservatonExtraServiceRepository extends JpaRepository<ReservationExtraServiceRelation, ReservationExtraServicePK> {

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
}
