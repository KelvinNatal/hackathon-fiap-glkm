package com.fiap.hackathon.services;

import com.fiap.hackathon.dtos.ExtraServiceResponseDTO;
import com.fiap.hackathon.dtos.ReservationCompleteResponseDTO;
import com.fiap.hackathon.dtos.ReservationRequestDTO;
import com.fiap.hackathon.entities.ReservationEntity;
import com.fiap.hackathon.entities.ReservationExtraServiceRelation;
import com.fiap.hackathon.mappers.ExtraServiceMapper;
import com.fiap.hackathon.projection.ExtraServiceProjection;
import com.fiap.hackathon.repositories.ClientRepository;
import com.fiap.hackathon.repositories.ExtraServiceRepository;
import com.fiap.hackathon.repositories.ReservationRepository;
import com.fiap.hackathon.repositories.ReservatonExtraServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ClientRepository clientRepository;

    private final ExtraServiceRepository extraServiceRepository;

    private final ReservatonExtraServiceRepository reservatonExtraServiceRepository;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, ExtraServiceRepository extraServiceRepository, ReservatonExtraServiceRepository reservatonExtraServiceRepository) {
        this.reservationRepository = reservationRepository;
        this.extraServiceRepository = extraServiceRepository;
        this.clientRepository = clientRepository;
        this.reservatonExtraServiceRepository = reservatonExtraServiceRepository;
    }

    @Transactional(readOnly = true)
    public ReservationCompleteResponseDTO getReservation(UUID id){
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        List<ExtraServiceProjection> extraServiceListProjection = reservatonExtraServiceRepository.getAllExtraServicesBoundReservation(id);
        List<ExtraServiceResponseDTO> extraServiceList = new ArrayList<>();

        extraServiceListProjection.forEach(service -> extraServiceList.add(ExtraServiceMapper.extraserviceProjectionToExtraServiceResponseDTO(service)));

        return new ReservationCompleteResponseDTO(reservationEntity, extraServiceList);
    }

    @Transactional
    public ReservationEntity createReservation(ReservationRequestDTO reservationRequestDTO){
        clientRepository.findById(reservationRequestDTO.idClient()).orElseThrow(() -> new EntityNotFoundException("client not found"));

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setIdClient(reservationRequestDTO.idClient());
        reservationEntity.setIdRoom(reservationRequestDTO.idRoom());
        reservationEntity.setStartDate(reservationRequestDTO.startDate());
        reservationEntity.setEndDate(reservationRequestDTO.endDate());

        reservationRepository.save(reservationEntity);

        reservationRequestDTO.serviceList().forEach(extraService -> {
            ReservationExtraServiceRelation reservationExtraServiceRelation = new ReservationExtraServiceRelation();
            reservationExtraServiceRelation.getReservationExtraServicePK().setReservation(reservationEntity);
            reservationExtraServiceRelation.getReservationExtraServicePK().setExtraService(extraServiceRepository.findById(extraService).orElseThrow(() -> new EntityNotFoundException("service " + extraService + " not found")));
            reservatonExtraServiceRepository.save(reservationExtraServiceRelation);
        });

        return reservationEntity;
    }

    public void deleteReservation(){

    }
}
