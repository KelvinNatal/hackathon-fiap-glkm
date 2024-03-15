package com.fiap.hackathon.accomodation.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AccommodationResponseDTO(
        UUID id,
        String name,
        Integer guests,
        BigDecimal cost,
        UUID propertyId
) {
}
