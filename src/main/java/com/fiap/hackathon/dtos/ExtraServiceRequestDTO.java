package com.fiap.hackathon.dtos;

import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public record ExtraServiceRequestDTO(
        @NotNull
        String name,
        @NotNull
        BigDecimal cost

){
}
