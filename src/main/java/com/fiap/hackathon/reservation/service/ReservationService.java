package com.fiap.hackathon.reservation.service;

import com.fiap.hackathon.aditional.repository.AdditionalRepository;
import com.fiap.hackathon.client.repository.ClientRepository;
import com.fiap.hackathon.extraservice.dto.ExtraServiceResponseDTO;
import com.fiap.hackathon.extraservice.mapper.ExtraServiceMapper;
import com.fiap.hackathon.extraservice.projection.ExtraServiceProjection;
import com.fiap.hackathon.extraservice.repository.ExtraServiceRepository;
import com.fiap.hackathon.global.relation.reservationadditional.entity.ReservationAdditionalRelation;
import com.fiap.hackathon.global.relation.reservationextraservice.entity.ReservationExtraServiceRelation;
import com.fiap.hackathon.global.relation.reservationextraservice.repository.ReservatonExtraServiceRepository;
import com.fiap.hackathon.global.relation.reservationadditional.repository.ReservatonAdditionalRepository;
import com.fiap.hackathon.reservation.dto.ReservationAddItemRequestDTO;
import com.fiap.hackathon.reservation.dto.ReservationCompleteResponseDTO;
import com.fiap.hackathon.reservation.dto.ReservationRequestDTO;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
import com.fiap.hackathon.reservation.repository.ReservationRepository;
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

    private final AdditionalRepository additionalRepository;

    private final ExtraServiceRepository extraServiceRepository;

    private final ReservatonExtraServiceRepository reservationExtraServiceRepository;

    private final ReservatonAdditionalRepository reservatonAdditionalRepository;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, ExtraServiceRepository extraServiceRepository, ReservatonExtraServiceRepository reservationExtraServiceRepository, AdditionalRepository additionalRepository,  ReservatonAdditionalRepository reservatonAdditionalRepository) {
        this.reservationRepository = reservationRepository;
        this.extraServiceRepository = extraServiceRepository;
        this.clientRepository = clientRepository;
        this.reservationExtraServiceRepository = reservationExtraServiceRepository;
        this.additionalRepository = additionalRepository;
        this.reservatonAdditionalRepository = reservatonAdditionalRepository;
    }

    /*@Transactional(readOnly = true)
    public ReservationCompleteResponseDTO getReservation(UUID id){
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        List<ExtraServiceProjection> extraServiceListProjection = reservationExtraServiceRepository.getAllExtraServicesBoundReservation(id);
        List<ExtraServiceResponseDTO> extraServiceList = new ArrayList<>();

        extraServiceListProjection.forEach(service -> extraServiceList.add(ExtraServiceMapper.extraserviceProjectionToExtraServiceResponseDTO(service)));

        return new ReservationCompleteResponseDTO(reservationEntity, extraServiceList, totalReservation(id));
    }*/

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
            reservationExtraServiceRepository.save(reservationExtraServiceRelation);
        });

        return reservationEntity;
    }

    @Transactional
    public void addItemReservation(UUID id, ReservationAddItemRequestDTO reservationAddItemRequestDTO){
        reservationAddItemRequestDTO.itemList().forEach(item -> {
            ReservationAdditionalRelation reservationAdditionalRelation = new ReservationAdditionalRelation();
            reservationAdditionalRelation.getReservationAdditionalPK().setReservation(reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found")));
            reservationAdditionalRelation.getReservationAdditionalPK().setAdditional(additionalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("additional not found")));
        });
    }

    public void checkoutReservation(){

    }

    @Transactional
    public void deleteReservation(UUID id){
        reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        List<ReservationExtraServiceRelation> reservationExtraServiceProjection = reservationExtraServiceRepository.getReservationsService(id);
        List<ReservationAdditionalRelation> reservationAdditionalRelations = reservatonAdditionalRepository.getReservationsAdditional(id);
        reservationAdditionalRelations.forEach(additional -> reservatonAdditionalRepository.deleteReservationAdditionalRelationByReservationId(additional.getReservationAdditionalPK().getReservation().getId()));
        reservationExtraServiceProjection.forEach(reservation -> reservationExtraServiceRepository.deleteReservationExtraServiceRelationByReservationId(reservation.getReservationExtraServicePK().getReservation().getId()));

        reservationRepository.deleteById(id);
    }

    public BigDecimal totalReservation(UUID id){
        List<ExtraServiceProjection> extraServiceListProjection = reservationExtraServiceRepository.getAllExtraServicesBoundReservation(id);
        List<AdditionalProjection> additionalListProjection = reservatonAdditionalRepository.getAllAdditionalsBoundReservation(id);

        BigDecimal extraServiceTotal = BigDecimal.ZERO;
        BigDecimal itemsTotal = BigDecimal.ZERO;
        BigDecimal total;

        for (ExtraServiceProjection extraService : extraServiceListProjection) {
            extraServiceTotal = extraServiceTotal.add(extraService.getCost());
        }

        for (AdditionalProjection additional : additionalListProjection) {
            itemsTotal = itemsTotal.add(additional.getCost());
        }

        total = extraServiceTotal.add(itemsTotal);

        return total;
    }
}
