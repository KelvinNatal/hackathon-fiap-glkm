package com.fiap.hackathon.reservation.repository;

import com.fiap.hackathon.global.relation.reservationextraservice.entity.ReservationExtraServiceRelation;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {
    @Query(nativeQuery = true,
            value = "SELECT id, id_room, id_client, start_date, end_date " +
                    "FROM reservations " +
                    "WHERE id_room = :idRoom AND :startDateRequest BETWEEN start_date AND end_date")
    ReservationEntity validateDisponibility(@Param("idRoom") UUID idRoom,
                                            @Param("startDateRequest") LocalDateTime startDateRequest);

    ReservationEntity findByIdRoom(UUID id);
}
