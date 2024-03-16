package com.fiap.hackathon.property.mapper;

import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.mapper.AccommodationMapper;
import com.fiap.hackathon.property.dto.PropertyRequestDTO;
import com.fiap.hackathon.property.dto.PropertyResponseDTO;
import com.fiap.hackathon.property.dto.PropertyResponseWithoutAccommodationsDTO;
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

    default PropertyResponseDTO propertyToPropertyResponseDTO(Property property, List<Accommodation> accommodations) {
        return mapPropertyToPropertyResponseDTO(property, accommodations);
    }

    List<PropertyResponseWithoutAccommodationsDTO> propertiesToPropertyResponseWithoutAccommodationsDTO(List<Property> properties);

    default PropertyResponseDTO mapPropertyToPropertyResponseDTO(Property property, List<Accommodation> accommodations) {
        return new PropertyResponseDTO(
                property.getId(),
                property.getName(),
                property.getAddress(),
                property.getCity(),
                property.getDistrict(),
                property.getState(),
                property.getCountry(),
                AccommodationMapper.INSTANCE.accommodationsToAccommodationResponseWithoutPropertyDTO(accommodations)
        );
    }
}
