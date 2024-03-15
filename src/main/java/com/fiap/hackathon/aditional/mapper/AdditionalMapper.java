package com.fiap.hackathon.aditional.mapper;

import com.fiap.hackathon.aditional.dto.AdditionalResponseDTO;
import com.fiap.hackathon.aditional.entity.AdditionalEntity;

import java.math.BigDecimal;

public class AdditionalMapper {

    public static AdditionalEntity additionalDTOtoAdditional(String name, BigDecimal cost) {
        AdditionalEntity additional = new AdditionalEntity();

        additional.setName(name);
        additional.setCost(cost);

        return additional;
    }

    public static AdditionalResponseDTO additionalToAdditionalDTO(AdditionalEntity additional) {
        return new AdditionalResponseDTO(additional.getIdAdditional(), additional.getName(), additional.getCost());
    }

    ;

}
