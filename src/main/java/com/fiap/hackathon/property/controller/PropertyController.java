package com.fiap.hackathon.property.controller;

import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.service.AccommodationService;
import com.fiap.hackathon.property.dto.PropertyRequestDTO;
import com.fiap.hackathon.property.entity.Property;
import com.fiap.hackathon.property.mapper.PropertyMapper;
import com.fiap.hackathon.property.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/properties", produces = MediaType.APPLICATION_JSON_VALUE)
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertiesToPropertyResponseWithoutAccommodationsDTO(properties));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPropertyById(@PathVariable UUID id) {
        Property property = propertyService.getPropertyById(id);
        List<Accommodation> accommodations = accommodationService.getAllAccommodationsByPropertyId(property.getId());

        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(property, accommodations));
    }

    @PostMapping
    public ResponseEntity createProperty(@RequestBody @Valid PropertyRequestDTO property) {
        Property createdProperty = propertyService.createProperty(PropertyMapper.INSTANCE.propertyRequestDTOToProperty(property));
        List<Accommodation> accommodations = new ArrayList<>();
        return new ResponseEntity(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(createdProperty, accommodations), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProperty(@PathVariable UUID id, @RequestBody @Valid PropertyRequestDTO property) {
        Property updatedProperty = propertyService.updateProperty(id, PropertyMapper.INSTANCE.propertyRequestDTOToProperty(property));
        List<Accommodation> accommodations = accommodationService.getAllAccommodationsByPropertyId(updatedProperty.getId());
        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(updatedProperty, accommodations));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProperty(@PathVariable UUID id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
