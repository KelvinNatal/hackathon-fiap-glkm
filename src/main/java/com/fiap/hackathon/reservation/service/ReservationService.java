package com.fiap.hackathon.reservation.service;

import com.fiap.hackathon.accomodation.entity.Accommodation;
import com.fiap.hackathon.accomodation.repository.AccomodationRepository;
import com.fiap.hackathon.aditional.dto.AdditionalResponseDTO;
import com.fiap.hackathon.aditional.mapper.AdditionalMapper;
import com.fiap.hackathon.aditional.projection.AdditionalProjection;
import com.fiap.hackathon.aditional.repository.AdditionalRepository;
import com.fiap.hackathon.client.entity.ClientEntity;
import com.fiap.hackathon.client.mapper.ClientMapper;
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
import com.fiap.hackathon.reservation.dto.ReservationUpdateRequestDTO;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
import com.fiap.hackathon.reservation.mapper.ReservationMapper;
import com.fiap.hackathon.reservation.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ClientRepository clientRepository;

    private final AdditionalRepository additionalRepository;

    private final AccomodationRepository accomodationRepository;

    private final ExtraServiceRepository extraServiceRepository;

    private final ReservatonExtraServiceRepository reservationExtraServiceRepository;

    private final ReservatonAdditionalRepository reservatonAdditionalRepository;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, ExtraServiceRepository extraServiceRepository, ReservatonExtraServiceRepository reservationExtraServiceRepository, AdditionalRepository additionalRepository,  ReservatonAdditionalRepository reservatonAdditionalRepository, AccomodationRepository accomodationRepository) {
        this.reservationRepository = reservationRepository;
        this.extraServiceRepository = extraServiceRepository;
        this.clientRepository = clientRepository;
        this.reservationExtraServiceRepository = reservationExtraServiceRepository;
        this.additionalRepository = additionalRepository;
        this.reservatonAdditionalRepository = reservatonAdditionalRepository;
        this.accomodationRepository = accomodationRepository;
    }

    @Transactional(readOnly = true)
    public ReservationCompleteResponseDTO getReservation(UUID id){
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        List<ExtraServiceProjection> extraServiceListProjection = reservationExtraServiceRepository.getAllExtraServicesBoundReservation(id);
        List<AdditionalProjection> additionalProjection = reservatonAdditionalRepository.getAllAdditionalsBoundReservation(id);

        List<ExtraServiceResponseDTO> extraServiceList = new ArrayList<>();
        List<AdditionalResponseDTO> additionalList = new ArrayList<>();

        extraServiceListProjection.forEach(service -> extraServiceList.add(ExtraServiceMapper.extraserviceProjectionToExtraServiceResponseDTO(service)));
        additionalProjection.forEach(additional -> additionalList.add(AdditionalMapper.additionalProjectionToAdditionalResponseDTO(additional)));
        return new ReservationCompleteResponseDTO(reservationEntity, extraServiceList, totalReservation(id));
    }

    @Transactional
    public ReservationEntity createReservation(ReservationRequestDTO reservationRequestDTO){
        clientRepository.findById(reservationRequestDTO.idClient()).orElseThrow(() -> new EntityNotFoundException("client not found"));

        if(reservationRepository.validateDisponibility(reservationRequestDTO.idRoom(), reservationRequestDTO.startDate()) != null){
            throw new DataIntegrityViolationException("already exists a reservation on this date");
        }

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
            reservationAdditionalRelation.getReservationAdditionalPK().setAdditional(additionalRepository.findById(item).orElseThrow(() -> new EntityNotFoundException("additional not found")));
        });
    }

    @Transactional
    public ReservationEntity updateReservation(UUID id, ReservationUpdateRequestDTO reservationUpdateRequestDTO){
        if (reservationUpdateRequestDTO.toString().replace("ReservationUpdateRequestDTO[", "").replace("]", "").split("null").length == 7) {
            throw new IllegalArgumentException("at least one attribute needs to be valid");
        }

        ReservationEntity updateReservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));
        return reservationRepository.save(ReservationMapper.reservationUpdateDTOToReservation(reservationUpdateRequestDTO, updateReservation));
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
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        List<ExtraServiceProjection> extraServiceListProjection = reservationExtraServiceRepository.getAllExtraServicesBoundReservation(id);
        List<AdditionalProjection> additionalListProjection = reservatonAdditionalRepository.getAllAdditionalsBoundReservation(id);
        Accommodation accommodation = accomodationRepository.findById(reservationEntity.getIdRoom()).orElseThrow(() -> new EntityNotFoundException("accomodation not found"));

        BigDecimal extraServiceTotal = BigDecimal.ZERO;
        BigDecimal itemsTotal = BigDecimal.ZERO;
        BigDecimal total;

        for (ExtraServiceProjection extraService : extraServiceListProjection) {
            extraServiceTotal = extraServiceTotal.add(extraService.getCost());
        }

        for (AdditionalProjection additional : additionalListProjection) {
            itemsTotal = itemsTotal.add(additional.getCost());
        }

        total = extraServiceTotal.add(itemsTotal).add(accommodation.getCost());

        return total;
    }
}
