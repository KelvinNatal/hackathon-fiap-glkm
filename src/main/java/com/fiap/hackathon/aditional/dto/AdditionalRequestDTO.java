package com.fiap.hackathon.aditional.dto;

import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public record AdditionalRequestDTO(
        @NotNull
        String name,
        @NotNull
        BigDecimal cost

) {
}
