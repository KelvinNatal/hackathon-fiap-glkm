package com.fiap.hackathon.client.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ClientResponseDTO(
        UUID id,

        String cpf,

        String passport,

        String name,

        String originCountry,

        LocalDate birthDate,

        String address,

        String telephone,

        String email
) {
}
