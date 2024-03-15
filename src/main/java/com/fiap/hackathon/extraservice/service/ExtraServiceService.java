package com.fiap.hackathon.extraservice.service;

import com.fiap.hackathon.extraservice.dto.ExtraServiceResponseDTO;
import com.fiap.hackathon.extraservice.entity.ExtraServiceEntity;
import com.fiap.hackathon.extraservice.mapper.ExtraServiceMapper;
import com.fiap.hackathon.extraservice.repository.ExtraServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ExtraServiceService {

    private final ExtraServiceRepository extraServiceRepository;

    public ExtraServiceService(ExtraServiceRepository extraServiceRepository) {
        this.extraServiceRepository = extraServiceRepository;
    }

    @Transactional(readOnly = true)
    public Page<ExtraServiceResponseDTO> getAllExtraServices(Pageable pageable) {
        Page<ExtraServiceEntity> extraServicePage = extraServiceRepository.findAll(pageable);
        return extraServicePage.map(ExtraServiceMapper::extraServiceToExtraServiceDTO);
    }

    @Transactional(readOnly = true)
    public ExtraServiceEntity getByIdService(UUID id) {
        return extraServiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("extra service not found"));
    }


    @Transactional
    public ExtraServiceEntity createExtraService(String name, BigDecimal cost) {
        return extraServiceRepository.save(ExtraServiceMapper.extraServiceDTOtoExtraService(name, cost));
    }

    @Transactional
    public void removeExtraService(UUID idService) {
        extraServiceRepository.findById(idService).orElseThrow(() -> new EntityNotFoundException("extra service not found"));
        extraServiceRepository.deleteById(idService);
    }

    @Transactional
    public ExtraServiceEntity updateValue(UUID idService, BigDecimal cost) {
        ExtraServiceEntity extraServiceEntity = extraServiceRepository.findById(idService).orElseThrow(() -> new EntityNotFoundException("extra service not found"));
        extraServiceEntity.setCost(cost);

        return extraServiceRepository.save(extraServiceEntity);
    }
}
