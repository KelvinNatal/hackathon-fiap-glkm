package com.fiap.hackathon.extraservice.controller;

import com.fiap.hackathon.extraservice.dto.ExtraServiceResponseDTO;
import com.fiap.hackathon.extraservice.entity.ExtraServiceEntity;
import com.fiap.hackathon.extraservice.service.ExtraServiceService;
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
@RequestMapping(path = "/api/v1/extraService", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExtraServiceController {

    @Autowired
    private ExtraServiceService extraServiceService;

    @GetMapping
    public ResponseEntity<Page<ExtraServiceResponseDTO>> getAllExtraServices(Pageable pageable) {
        Page<ExtraServiceResponseDTO> extraServices = extraServiceService.getAllExtraServices(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(extraServices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtraServiceEntity> getByIdService(@PathVariable UUID id) {
        ExtraServiceEntity extraServiceEntity = extraServiceService.getByIdService(id);

        return ResponseEntity.status(HttpStatus.OK).body(extraServiceEntity);
    }

    @PostMapping()
    public ResponseEntity<ExtraServiceEntity> createExtraService(@RequestParam String name, @RequestParam BigDecimal value) {
        ExtraServiceEntity extraServiceEntity = extraServiceService.createExtraService(name, value);

        return ResponseEntity.status(HttpStatus.CREATED).body(extraServiceEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeExtraService(@PathVariable UUID id) throws JSONException {
        extraServiceService.removeExtraService(id);

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "extra service successfully removed");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtraServiceEntity> updateValue(@PathVariable UUID id, @RequestParam BigDecimal value) throws JSONException {
        ExtraServiceEntity extraServiceEntity = extraServiceService.updateValue(id, value);

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "extra service value successfully updated");
        return ResponseEntity.status(HttpStatus.OK).body(extraServiceEntity);
    }
}
