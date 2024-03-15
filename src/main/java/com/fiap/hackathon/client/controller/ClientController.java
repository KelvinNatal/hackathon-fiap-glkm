package com.fiap.hackathon.client.controller;

import com.fiap.hackathon.client.dto.ClientRequestDTO;
import com.fiap.hackathon.client.dto.ClientUpdateDTO;
import com.fiap.hackathon.client.entity.ClientEntity;
import com.fiap.hackathon.client.service.ClientService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientEntity>> getAllClients(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        ClientEntity clientEntity = clientService.registerClient(clientRequestDTO);

        JSONObject respondeBody = new JSONObject();
        respondeBody.put("id:", clientEntity.getId());
        respondeBody.put("message:", "Successufuly registered client");

        return ResponseEntity.status(HttpStatus.CREATED).body(respondeBody.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable UUID id, @RequestBody @Valid ClientUpdateDTO clientUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, clientUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
