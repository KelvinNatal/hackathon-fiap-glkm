package com.fiap.hackathon.mappers;

import com.fiap.hackathon.dtos.ClientRequestDTO;
import com.fiap.hackathon.dtos.ClientUpdateDTO;
import com.fiap.hackathon.entities.ClientEntity;

public abstract class ClientMapper {

    public static ClientEntity clientDTOToClient(ClientRequestDTO clientRequestDTO) {
        ClientEntity client = new ClientEntity();

        if (clientRequestDTO.passport() == null && !clientRequestDTO.originCountry().equalsIgnoreCase("Brasil")) {
            throw new IllegalArgumentException("Passport cannot be null");
        }

        client.setName(clientRequestDTO.name());
        client.setCpf(clientRequestDTO.cpf());
        client.setPassport(clientRequestDTO.passport());
        client.setOriginCountry(clientRequestDTO.originCountry());
        client.setEmail(clientRequestDTO.email());
        client.setTelephone(clientRequestDTO.telephone());
        client.setAddress(clientRequestDTO.address());
        client.setBirthDate(clientRequestDTO.birthDate());

        return client;
    }

    public static ClientEntity clientUpdateDTOToUser(ClientUpdateDTO clientUpdateDTO, ClientEntity updateClient) {
        if (clientUpdateDTO.cpf() != null) {
            updateClient.setCpf(clientUpdateDTO.cpf());
        }

        if (clientUpdateDTO.passport() != null) {
            updateClient.setPassport(clientUpdateDTO.passport());
        }

        if (clientUpdateDTO.originCountry() != null) {
            updateClient.setOriginCountry(clientUpdateDTO.originCountry());
        }

        if (clientUpdateDTO.name() != null) {
            updateClient.setName(clientUpdateDTO.name());
        }

        if (clientUpdateDTO.birthDate() != null) {
            updateClient.setBirthDate(clientUpdateDTO.birthDate());
        }

        if (clientUpdateDTO.address() != null) {
            updateClient.setAddress(clientUpdateDTO.address());
        }

        if (clientUpdateDTO.telephone() != null) {
            updateClient.setTelephone(clientUpdateDTO.telephone());
        }

        if (clientUpdateDTO.email() != null) {
            updateClient.setEmail(clientUpdateDTO.email());
        }

        return updateClient;
    }
}
