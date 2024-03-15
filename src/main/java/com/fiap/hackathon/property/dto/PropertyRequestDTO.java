package com.fiap.hackathon.property.dto;

import jakarta.validation.constraints.NotBlank;

public record PropertyRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        String address,
        @NotBlank
        String city,
        @NotBlank
        String district,
        @NotBlank
        String state,
        @NotBlank
        String country
) {
}
