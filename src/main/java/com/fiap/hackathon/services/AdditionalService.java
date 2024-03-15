package com.fiap.hackathon.services;

import com.fiap.hackathon.dtos.AdditionalResponseDTO;
import com.fiap.hackathon.entities.AdditionalEntity;
import com.fiap.hackathon.mappers.AdditionalMapper;
import com.fiap.hackathon.repositories.AdditionalRepository;
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
    public AdditionalEntity getByIdAdditional(UUID id){
        return additionalRepository.findByIdAdditional(id);
    }


    @Transactional
    public AdditionalEntity createAdditional(String name, BigDecimal cost){
        return additionalRepository.save(AdditionalMapper.additionalDTOtoAdditional(name, cost));
    }

    @Transactional
    public void removeAdditional(UUID id){
        AdditionalEntity additional = additionalRepository.findByIdAdditional(id);


        if(additional == null) {
            throw new RuntimeException("additional not exists");
        }

        additionalRepository.deleteByIdAdditional(id);
    }

    @Transactional
    public AdditionalEntity updateValue(UUID id, BigDecimal cost){
        AdditionalEntity additional = additionalRepository.findByIdAdditional(id);
        if(additional == null) {
            throw new RuntimeException("additional not exists");
        }

        additional.setCost(cost);

        return additionalRepository.save(additional);
    }
}