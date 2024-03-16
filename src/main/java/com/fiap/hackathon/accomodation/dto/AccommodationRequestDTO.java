package com.fiap.hackathon.accomodation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record AccommodationRequestDTO(
        @NotBlank
        String name,
        @NotNull
        @Positive
        Integer guests,
        @NotNull
        @Positive
        BigDecimal cost,
        @NotNull
        UUID propertyId
) {
}
