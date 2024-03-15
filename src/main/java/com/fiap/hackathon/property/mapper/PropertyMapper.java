package com.fiap.hackathon.property.mapper;

import com.fiap.hackathon.property.dto.PropertyRequestDTO;
import com.fiap.hackathon.property.dto.PropertyResponseDTO;
import com.fiap.hackathon.property.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    @Mapping(target = "id", ignore = true)
    Property propertyRequestDTOToProperty(PropertyRequestDTO propertyRequestDTO);

    PropertyResponseDTO propertyToPropertyResponseDTO(Property property);

    List<PropertyResponseDTO> propertiesToPropertyResponseDTO(List<Property> propertys);
}
