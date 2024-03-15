package com.fiap.hackathon.reservation.dto;

import com.fiap.hackathon.extraservice.dto.ExtraServiceResponseDTO;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationCompleteResponseDTO {

    private ReservationEntity reservation;

    private List<ExtraServiceResponseDTO> extraServices;

    private BigDecimal total;

    public ReservationCompleteResponseDTO(ReservationEntity reservation, List<ExtraServiceResponseDTO> extraServices, BigDecimal total) {
        this.reservation = reservation;
        this.extraServices = extraServices;
        this.total = total;
    }
}
