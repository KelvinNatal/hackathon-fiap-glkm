package com.fiap.hackathon.accomodation.service;

import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.repository.AccomodationRepository;
import com.fiap.hackathon.property.entity.Property;
import com.fiap.hackathon.property.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccommodationService {
    @Autowired
    private AccomodationRepository accommodationRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    public Accommodation getAccommodationById(UUID id) {
        return accommodationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("accommodation not found"));
    }

    public Accommodation createAccommodation(Accommodation accommodation) {
        // TODO: Se der tempo, colocar a validação de property + accommodationNumber
        Property existingProperty = propertyRepository.findById(accommodation.getProperty().getId()).orElseThrow(() -> new EntityNotFoundException("property not found"));
        Accommodation existingAccommodation = accommodationRepository.findByName(accommodation.getName());

        if (existingAccommodation != null) {
            throw new IllegalArgumentException("accommodation already exists");
        }

        return accommodationRepository.save(accommodation);
    }

    public Accommodation updateAccommodation(UUID id, Accommodation accommodation) {
        Accommodation existingAccommodation = accommodationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("accommodation not found"));

        existingAccommodation.setName(accommodation.getName());
        existingAccommodation.setGuests(accommodation.getGuests());
        existingAccommodation.setCost(accommodation.getCost());

        return accommodationRepository.save(existingAccommodation);
    }

    public void deleteAccommodation(UUID id) {
        if (accommodationRepository.existsById(id)) {
            accommodationRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("accommodation not found");
        }
    }
}
