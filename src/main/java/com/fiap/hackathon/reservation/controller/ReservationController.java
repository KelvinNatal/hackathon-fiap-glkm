package com.fiap.hackathon.reservation.controller;

import com.fiap.hackathon.reservation.dto.ReservationCompleteResponseDTO;
import com.fiap.hackathon.reservation.dto.ReservationRequestDTO;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
import com.fiap.hackathon.reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationCompleteResponseDTO> getReservation(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservation(id));
    }

    @PostMapping
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(reservationRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> addItemReservation(@PathVariable UUID id, @Valid @RequestBody Reser reservationAddItemRequestDTO){
        reservationService.addItemReservation(id, reservationAddItemRequestDTO);
        JSONObject response = new JSONObject();

        response.put("message:","Additionals successufully added");
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

    public void getAllReservationsByLocation(){

    }

    public void updateReservation(){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID id){
        reservationService.deleteReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
