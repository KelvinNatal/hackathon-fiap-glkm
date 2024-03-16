package com.fiap.hackathon.reservation.mapper;

import com.fiap.hackathon.reservation.dto.ReservationUpdateRequestDTO;
import com.fiap.hackathon.reservation.entity.ReservationEntity;

import java.util.UUID;

public abstract class ReservationMapper {

    public static ReservationEntity reservationUpdateDTOToReservation(ReservationUpdateRequestDTO reservationUpdateRequestDTO, ReservationEntity updateReservation) {
        if (reservationUpdateRequestDTO.idRoom()!= null) {
            updateReservation.setIdRoom(UUID.fromString(reservationUpdateRequestDTO.idRoom()));
        }

        if (reservationUpdateRequestDTO.startDate() != null) {
            updateReservation.setStartDate(reservationUpdateRequestDTO.startDate());
        }

        if (reservationUpdateRequestDTO.endDate() != null) {
            updateReservation.setEndDate(reservationUpdateRequestDTO.endDate());
        }

        return updateReservation;
    }
}
