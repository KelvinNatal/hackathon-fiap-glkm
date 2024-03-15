package com.fiap.hackathon.mappers;

import com.fiap.hackathon.dtos.ExtraServiceResponseDTO;
import com.fiap.hackathon.entities.ExtraServiceEntity;
import com.fiap.hackathon.projection.ExtraServiceProjection;
import com.fiap.hackathon.utils.Utils;

import java.math.BigDecimal;

public abstract class ExtraServiceMapper {
    public static ExtraServiceEntity extraServiceDTOtoExtraService(String name, BigDecimal cost){
        ExtraServiceEntity extraServiceEntity = new ExtraServiceEntity();
        extraServiceEntity.setName(name);
        extraServiceEntity.setCost(cost);

        return extraServiceEntity;
    }

    public static ExtraServiceResponseDTO extraServiceToExtraServiceDTO(ExtraServiceEntity extraServiceEntity) {
        return new ExtraServiceResponseDTO(extraServiceEntity.getId(), extraServiceEntity.getName(), extraServiceEntity.getCost());
    }

    public static ExtraServiceResponseDTO extraserviceProjectionToExtraServiceResponseDTO(ExtraServiceProjection extraServiceProjection) {
        return new ExtraServiceResponseDTO(Utils.convertBytesToUUID(extraServiceProjection.getId()),
                extraServiceProjection.getName(), extraServiceProjection.getCost());
    }
}
