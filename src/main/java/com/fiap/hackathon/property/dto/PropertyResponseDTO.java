package com.fiap.hackathon.property.dto;

import java.util.UUID;

public record PropertyResponseDTO(
        UUID id,
        String name,
        String address,
        String city,
        String district,
        String state,
        String country
) {
}
