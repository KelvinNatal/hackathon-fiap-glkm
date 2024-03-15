package com.fiap.hackathon.property.controller;

import com.fiap.hackathon.property.dto.PropertyRequestDTO;
import com.fiap.hackathon.property.entity.Property;
import com.fiap.hackathon.property.mapper.PropertyMapper;
import com.fiap.hackathon.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/properties", produces = MediaType.APPLICATION_JSON_VALUE)
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertiesToPropertyResponseDTO(properties));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPropertyById(@PathVariable UUID id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(property));
    }

    @PostMapping
    public ResponseEntity createProperty(@RequestBody PropertyRequestDTO property) {
        Property createdProperty = propertyService.createProperty(PropertyMapper.INSTANCE.propertyRequestDTOToProperty(property));
        return new ResponseEntity(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(createdProperty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProperty(@PathVariable UUID id, @RequestBody PropertyRequestDTO property) {
        Property updatedProperty = propertyService.updateProperty(id, PropertyMapper.INSTANCE.propertyRequestDTOToProperty(property));
        return ResponseEntity.ok(PropertyMapper.INSTANCE.propertyToPropertyResponseDTO(updatedProperty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProperty(@PathVariable UUID id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
