package com.fiap.hackathon.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ExtraServiceResponseDTO(
        UUID id,
        String name,
        BigDecimal cost
) {


}
