package com.fiap.hackathon.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReservationRequestDTO(
        @NotBlank(message = "cannot be null or blank")
        UUID idRoom,

        @NotBlank(message = "cannot be null or blank")
        UUID idClient,

        @FutureOrPresent(message = "invalid start date")
        LocalDateTime startDate,

        @Future(message = "invalid end date")
        LocalDateTime endDate,

        List<UUID> serviceList
) {
}
