package com.fiap.hackathon.extraservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ExtraServiceResponseDTO(
        UUID id,
        String name,
        BigDecimal cost
) {


}
