package com.fiap.hackathon.accomodation.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AccommodationResponseWithoutPropertyDTO(
        UUID id,
        String name,
        Integer guests,
        BigDecimal cost
) {
}
