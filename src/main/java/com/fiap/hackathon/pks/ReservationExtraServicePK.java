package com.fiap.hackathon.pks;

import com.fiap.hackathon.entities.ExtraServiceEntity;
import com.fiap.hackathon.entities.ReservationEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class ReservationExtraServicePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "extra_service_id", nullable = false, foreignKey = @ForeignKey(name = "reservation_extra_service_extra_service_id_extra_services_id_fk"))
    private ExtraServiceEntity extraService;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false, foreignKey = @ForeignKey(name = "reservation_extra_service_reservation_id_reservations_id_fk"))
    private ReservationEntity reservation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationExtraServicePK that = (ReservationExtraServicePK) o;

        if (!Objects.equals(extraService, that.extraService)) return false;
        return Objects.equals(reservation, that.reservation);
    }

    @Override
    public int hashCode() {
        int result = extraService != null ? extraService.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }
}
