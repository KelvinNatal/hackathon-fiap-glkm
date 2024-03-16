package com.fiap.hackathon.reservation.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReservationUpdateRequestDTO(
        @NotBlank(message = "cannot be null or blank")
        String idRoom,

        @FutureOrPresent(message = "invalid start date")
        LocalDateTime startDate,

        @Future(message = "invalid end date")
        LocalDateTime endDate
) {
}
