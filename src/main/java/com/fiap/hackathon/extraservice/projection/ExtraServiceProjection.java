package com.fiap.hackathon.extraservice.projection;

import java.math.BigDecimal;

public interface ExtraServiceProjection {
    byte[] getId();

    String getName();

    BigDecimal getCost();
}
