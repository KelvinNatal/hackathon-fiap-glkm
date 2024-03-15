package com.fiap.hackathon.global.relation.reservationextraservice.projection;

import java.math.BigDecimal;

public interface ExtraServiceProjection {
    byte[] getId();
    String getName();
    BigDecimal getCost();
}
