package com.fiap.hackathon.services;

import com.fiap.hackathon.dtos.ClientRequestDTO;
import com.fiap.hackathon.dtos.ClientUpdateDTO;
import com.fiap.hackathon.entities.ClientEntity;
import com.fiap.hackathon.mappers.ClientMapper;
import com.fiap.hackathon.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Page<ClientEntity> getAllClients(Pageable pageable){
        return clientRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ClientEntity getClientById(UUID id){
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("client not found"));
    }

    @Transactional
    public ClientEntity registerClient(ClientRequestDTO clientRequestDTO){
        if(clientRepository.existsByCpf(clientRequestDTO.cpf())) throw new DataIntegrityViolationException("cpf already registered");
        if(clientRepository.existsByPassport(clientRequestDTO.passport())) throw new DataIntegrityViolationException("passport already registered");

        return clientRepository.save(ClientMapper.clientDTOToClient(clientRequestDTO));
    }

    @Transactional
    public ClientEntity updateClient(UUID id, ClientUpdateDTO clientUpdateDTO){
        if (clientUpdateDTO.toString().replace("ClientUpdateDTO[", "").replace("]", "").split("null").length == 7) {
            throw new IllegalArgumentException("at least one attribute needs to be valid");
        }

        ClientEntity updateClient = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("client not found"));
        return clientRepository.save(ClientMapper.clientUpdateDTOToUser(clientUpdateDTO, updateClient));
    }
    @Transactional
    public void deleteClient(UUID id){
        clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("client not found"));
        clientRepository.deleteById(id);
    }
}
