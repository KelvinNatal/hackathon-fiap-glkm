package com.fiap.hackathon.mappers;

import com.fiap.hackathon.dtos.AdditionalResponseDTO;
import com.fiap.hackathon.entities.AdditionalEntity;

import java.math.BigDecimal;

public class AdditionalMapper {

    public static AdditionalEntity additionalDTOtoAdditional(String name, BigDecimal cost){
        AdditionalEntity additional = new AdditionalEntity();

        additional.setName(name);
        additional.setCost(cost);

        return additional;
    }

    public static AdditionalResponseDTO additionalToAdditionalDTO(AdditionalEntity additional) {
        return new AdditionalResponseDTO(additional.getIdAdditional(), additional.getName(), additional.getCost());
    };

}



