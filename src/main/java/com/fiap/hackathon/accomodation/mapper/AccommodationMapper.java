package com.fiap.hackathon.accomodation.mapper;

import com.fiap.hackathon.accomodation.dto.AccommodationRequestDTO;
import com.fiap.hackathon.accomodation.dto.AccommodationResponseDTO;
import com.fiap.hackathon.accomodation.dto.AccommodationResponseWithoutPropertyDTO;
import com.fiap.hackathon.accomodation.entity.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public interface AccommodationMapper {
    AccommodationMapper INSTANCE = Mappers.getMapper(AccommodationMapper.class);

    @Mapping(target = "id", ignore = true)
    Accommodation accommodationRequestDTOToAccommodation(AccommodationRequestDTO accommodationRequestDTO);

    List<AccommodationResponseWithoutPropertyDTO> accommodationsToAccommodationResponseWithoutPropertyDTO(List<Accommodation> accommodations);

    default AccommodationResponseDTO accommodationToAccommodationResponseDTO(Accommodation accommodation) {
        return mapAccommodationToAccommodationResponseDTO(accommodation);
    }

    default List<AccommodationResponseDTO> accommodationsToAccommodationResponseDTO(List<Accommodation> accommodations) {
        return accommodations.stream()
                .map(accommodation -> new AccommodationResponseDTO(
                        accommodation.getId(),
                        accommodation.getName(),
                        accommodation.getGuests(),
                        accommodation.getCost(),
                        mapPropertyId(accommodation)
                ))
                .collect(Collectors.toList());
    }

    default AccommodationResponseDTO mapAccommodationToAccommodationResponseDTO(Accommodation accommodation) {
        return new AccommodationResponseDTO(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getGuests(),
                accommodation.getCost(),
                mapPropertyId(accommodation)
        );
    }

    default UUID mapPropertyId(Accommodation accommodation) {
        return accommodation.getProperty() != null ? accommodation.getProperty().getId() : null;
    }
}
