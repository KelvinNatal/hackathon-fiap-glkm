package com.fiap.hackathon.aditional.service;

import com.fiap.hackathon.aditional.dto.AdditionalResponseDTO;
import com.fiap.hackathon.aditional.entity.AdditionalEntity;
import com.fiap.hackathon.aditional.mapper.AdditionalMapper;
import com.fiap.hackathon.aditional.repository.AdditionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AdditionalService {

    @Autowired
    private AdditionalRepository additionalRepository;

    @Transactional(readOnly = true)
    public Page<AdditionalResponseDTO> getAllAdditional(Pageable pageable) {
        Page<AdditionalEntity> additionalPage = additionalRepository.findAll(pageable);
        return additionalPage.map(AdditionalMapper::additionalToAdditionalDTO);
    }

    @Transactional(readOnly = true)
    public AdditionalEntity getByIdAdditional(UUID id) {
        return additionalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("additional not found"));
    }


    @Transactional
    public AdditionalEntity createAdditional(String name, BigDecimal cost) {
        return additionalRepository.save(AdditionalMapper.additionalDTOtoAdditional(name, cost));
    }

    @Transactional
    public void removeAdditional(UUID id) {
        additionalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("additional not found"));

        additionalRepository.deleteById(id);
    }

    @Transactional
    public AdditionalEntity updateValue(UUID id, BigDecimal cost) {
        AdditionalEntity additional = additionalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("additional not found"));
        additional.setCost(cost);

        return additionalRepository.save(additional);
    }
}
