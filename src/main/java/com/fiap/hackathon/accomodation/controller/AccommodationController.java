package com.fiap.hackathon.accomodation.controller;

import com.fiap.hackathon.accomodation.dto.AccommodationRequestDTO;
import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.mapper.AccommodationMapper;
import com.fiap.hackathon.accomodation.service.AccommodationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/accommodations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity getAllAccommodations() {
        List<Accommodation> accommodations = accommodationService.getAllAccommodations();
        return ResponseEntity.ok(AccommodationMapper.INSTANCE.accommodationsToAccommodationResponseDTO(accommodations));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAccommodationById(@PathVariable UUID id) {
        Accommodation accommodation = accommodationService.getAccommodationById(id);
        return ResponseEntity.ok(AccommodationMapper.INSTANCE.accommodationToAccommodationResponseDTO(accommodation));
    }

    @PostMapping
    public ResponseEntity createAccommodation(@RequestBody @Valid AccommodationRequestDTO accommodation) {
        Accommodation createdAccommodation = accommodationService.createAccommodation(AccommodationMapper.INSTANCE.accommodationRequestDTOToAccommodation(accommodation), accommodation.propertyId());
        return new ResponseEntity(AccommodationMapper.INSTANCE.accommodationToAccommodationResponseDTO(createdAccommodation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccommodation(@PathVariable UUID id, @RequestBody AccommodationRequestDTO accommodation) {
        Accommodation updatedAccommodation = accommodationService.updateAccommodation(id, AccommodationMapper.INSTANCE.accommodationRequestDTOToAccommodation(accommodation));
        return ResponseEntity.ok(AccommodationMapper.INSTANCE.accommodationToAccommodationResponseDTO(updatedAccommodation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccommodation(@PathVariable UUID id) {
        accommodationService.deleteAccommodation(id);
        return ResponseEntity.noContent().build();
    }
}
