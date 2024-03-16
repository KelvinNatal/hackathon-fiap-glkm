package com.fiap.hackathon.aditional.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalEntityTest {

    @Test
    void shouldIdBeEquals() {
        AdditionalEntity additional= new AdditionalEntity();

        additional.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        additional.setName("Coca Cola");
        additional.setCost(BigDecimal.valueOf(14.99));

        String id = String.valueOf(additional.getId());
        Assertions.assertThat(id).isEqualTo("f724f494-9002-4f6f-aafa-a9bae54bd6ef");
    }

    @Test
    void shouldNameBeEquals() {
        AdditionalEntity additional= new AdditionalEntity();

        additional.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        additional.setName("Coca Cola");
        additional.setCost(BigDecimal.valueOf(14.99));

        String name = new String(additional.getName());
        Assertions.assertThat(name).isEqualTo("Coca Cola");
    }

    @Test
    void shouldCostBeEquals() {
        AdditionalEntity additional= new AdditionalEntity();

        additional.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        additional.setName("Coca Cola");
        additional.setCost(BigDecimal.valueOf(14.99));

        String cost = new String(String.valueOf(additional.getCost()));
        Assertions.assertThat(cost).isEqualTo("14.99");
    }

}