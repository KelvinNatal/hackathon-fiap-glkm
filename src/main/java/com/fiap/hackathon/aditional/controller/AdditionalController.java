package com.fiap.hackathon.aditional.controller;

import com.fiap.hackathon.aditional.dto.AdditionalResponseDTO;
import com.fiap.hackathon.aditional.entity.AdditionalEntity;
import com.fiap.hackathon.aditional.service.AdditionalService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/Additional", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdditionalController {

    @Autowired
    private AdditionalService additionalService;

    @GetMapping
    public ResponseEntity<Page<AdditionalResponseDTO>> getAllAdditional(Pageable pageable) {
        Page<AdditionalResponseDTO> additional = additionalService.getAllAdditional(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(additional);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdditionalEntity> getByIdAdditional(@PathVariable UUID id) {
        AdditionalEntity additional = additionalService.getByIdAdditional(id);


        return ResponseEntity.status(HttpStatus.OK).body(additional);
    }

    @PostMapping()
    public ResponseEntity<AdditionalEntity> createAdditional(@RequestParam String name, @RequestParam BigDecimal value) {
        AdditionalEntity additional = additionalService.createAdditional(name, value);

        return ResponseEntity.status(HttpStatus.CREATED).body(additional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeAdditional(@PathVariable UUID id) throws JSONException {
        additionalService.removeAdditional(id);

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "additional successfully removed");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdditionalEntity> updateValue(@PathVariable UUID id, @RequestParam BigDecimal value) throws JSONException {
        AdditionalEntity additional = additionalService.updateValue(id, value);

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "additional value successfully updated");
        return ResponseEntity.status(HttpStatus.OK).body(additional);
    }
}
