package com.fiap.hackathon.property.dto;

import com.fiap.hackathon.accomodation.dto.AccommodationResponseWithoutPropertyDTO;

import java.util.List;
import java.util.UUID;

public record PropertyResponseWithoutAccommodationsDTO(
        UUID id,
        String name,
        String address,
        String city,
        String district,
        String state,
        String country
) {
}
