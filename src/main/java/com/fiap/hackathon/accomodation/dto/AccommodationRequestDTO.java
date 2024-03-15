package com.fiap.hackathon.accomodation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AccommodationRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        Integer guests,
        @NotNull
        BigDecimal cost,
        @NotNull
        UUID propertyId
) {
}
