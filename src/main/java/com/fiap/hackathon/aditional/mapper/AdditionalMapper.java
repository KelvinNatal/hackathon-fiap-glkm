package com.fiap.hackathon.aditional.mapper;

import com.fiap.hackathon.aditional.dto.AdditionalResponseDTO;
import com.fiap.hackathon.aditional.entity.AdditionalEntity;
import com.fiap.hackathon.aditional.projection.AdditionalProjection;
import com.fiap.hackathon.extraservice.dto.ExtraServiceResponseDTO;
import com.fiap.hackathon.extraservice.projection.ExtraServiceProjection;
import com.fiap.hackathon.global.util.Utils;

import java.math.BigDecimal;

public class AdditionalMapper {

    public static AdditionalEntity additionalDTOtoAdditional(String name, BigDecimal cost) {
        AdditionalEntity additional = new AdditionalEntity();

        additional.setName(name);
        additional.setCost(cost);

        return additional;
    }

    public static AdditionalResponseDTO additionalToAdditionalDTO(AdditionalEntity additional) {
        return new AdditionalResponseDTO(additional.getId(), additional.getName(), additional.getCost());
    }

    public static AdditionalResponseDTO additionalProjectionToAdditionalResponseDTO(AdditionalProjection additionalProjection) {
        return new AdditionalResponseDTO(Utils.convertBytesToUUID(additionalProjection.getId()),
                additionalProjection.getName(), additionalProjection.getCost());
    }

}
