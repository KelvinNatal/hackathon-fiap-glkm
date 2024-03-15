package com.fiap.hackathon.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClientRequestDTO(

        @NotBlank(message = "cannot be null or blank")
        @CPF(message = "invalid cpf")
        String cpf,

        String passport,

        @NotBlank(message = "cannot be null or blank")
        String name,

        @NotBlank(message = "cannot be null or blank")
        String originCountry,

        @Past(message = "invalid date format")
        LocalDate birthDate,

        @NotBlank(message = "cannot be null or blank")
        String address,

        @NotBlank(message = "cannot be null or blank")
        String telephone,

        @NotBlank(message = "cannot be null or blank")
        String email
) {}
