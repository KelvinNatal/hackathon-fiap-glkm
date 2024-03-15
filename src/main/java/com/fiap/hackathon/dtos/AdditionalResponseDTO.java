package com.fiap.hackathon.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record AdditionalResponseDTO(

        UUID idService,
        String name,
        BigDecimal cost
) {


}
