package com.fiap.hackathon.extraservice.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ExtraServiceEntityTest {

    @Test
    void shouldIdBeEquals() {
        ExtraServiceEntity extraService= new ExtraServiceEntity();

        extraService.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        extraService.setName("Almoço");
        extraService.setCost(BigDecimal.valueOf(14.99));

        String id = String.valueOf(extraService.getId());
        Assertions.assertThat(id).isEqualTo("f724f494-9002-4f6f-aafa-a9bae54bd6ef");
    }

    @Test
    void shouldNameBeEquals() {
        ExtraServiceEntity extraService= new ExtraServiceEntity();

        extraService.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        extraService.setName("Almoço");
        extraService.setCost(BigDecimal.valueOf(14.99));

        String name = new String(extraService.getName());
        Assertions.assertThat(name).isEqualTo("Almoço");
    }

    @Test
    void shouldCostBeEquals() {
        ExtraServiceEntity extraService= new ExtraServiceEntity();

        extraService.setId(UUID.fromString("f724f494-9002-4f6f-aafa-a9bae54bd6ef"));
        extraService.setName("Almoço");
        extraService.setCost(BigDecimal.valueOf(14.99));

        String cost = new String(String.valueOf(extraService.getCost()));
        Assertions.assertThat(cost).isEqualTo("14.99");
    }

}