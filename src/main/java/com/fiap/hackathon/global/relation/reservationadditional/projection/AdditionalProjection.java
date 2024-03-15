package com.fiap.hackathon.global.relation.reservationadditional.projection;

import java.math.BigDecimal;

public interface AdditionalProjection {
    byte[] getId();
    String getName();
    BigDecimal getCost();
}
