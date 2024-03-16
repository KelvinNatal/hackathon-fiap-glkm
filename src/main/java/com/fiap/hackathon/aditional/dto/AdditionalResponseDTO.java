package com.fiap.hackathon.aditional.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AdditionalResponseDTO(
        UUID id,
        String name,
        BigDecimal cost
) {


}
