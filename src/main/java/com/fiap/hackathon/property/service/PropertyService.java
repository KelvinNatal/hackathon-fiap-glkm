package com.fiap.hackathon.property.service;

import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.repository.AccomodationRepository;
import com.fiap.hackathon.property.entity.Property;
import com.fiap.hackathon.property.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private AccomodationRepository accomodationRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(UUID id) {
        return propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("property not found"));
    }

    public Property createProperty(Property property) {
        Property existingProperty = propertyRepository.findByName(property.getName());

        if (existingProperty != null) {
            throw new DataIntegrityViolationException("property already exists");
        }

        return propertyRepository.save(property);
    }

    public Property updateProperty(UUID id, Property property) {
        Property existingProperty = propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("property not found"));

        existingProperty.setName(property.getName());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setCity(property.getCity());
        existingProperty.setDistrict(property.getDistrict());
        existingProperty.setState(property.getState());
        existingProperty.setCountry(property.getCountry());

        return propertyRepository.save(existingProperty);
    }

    @Transactional
    public void deleteProperty(UUID id) {
        if (propertyRepository.existsById(id)) {
            List<Accommodation> accommodations = accomodationRepository.findAllByPropertyId(id);
            for (Accommodation accommodation : accommodations) {
                accomodationRepository.deleteById(accommodation.getId());
            }

            propertyRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("property not found");
        }
    }
}
