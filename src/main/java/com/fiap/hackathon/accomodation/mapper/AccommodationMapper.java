package com.fiap.hackathon.accomodation.mapper;

import com.fiap.hackathon.accomodation.dto.AccommodationRequestDTO;
import com.fiap.hackathon.accomodation.dto.AccommodationResponseDTO;
import com.fiap.hackathon.accomodation.entity.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccommodationMapper {
    AccommodationMapper INSTANCE = Mappers.getMapper(AccommodationMapper.class);

    @Mapping(target = "id", ignore = true)
    Accommodation accommodationRequestDTOToAccommodation(AccommodationRequestDTO accommodationRequestDTO);

    AccommodationResponseDTO accommodationToAccommodationResponseDTO(Accommodation accommodation);

    List<AccommodationResponseDTO> accommodationsToAccommodationResponseDTO(List<Accommodation> accommodations);
}
