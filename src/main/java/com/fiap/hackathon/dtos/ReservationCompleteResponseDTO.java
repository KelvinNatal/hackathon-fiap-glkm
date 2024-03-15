package com.fiap.hackathon.dtos;

import com.fiap.hackathon.entities.ReservationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationCompleteResponseDTO {

    private ReservationEntity reservationEntity;

    private List<ExtraServiceResponseDTO> extraServiceEntity;

    public ReservationCompleteResponseDTO(ReservationEntity reservation, List<ExtraServiceResponseDTO> extraServices) {
        this.reservationEntity = reservation;
        this.extraServiceEntity = extraServices;
    }
}
