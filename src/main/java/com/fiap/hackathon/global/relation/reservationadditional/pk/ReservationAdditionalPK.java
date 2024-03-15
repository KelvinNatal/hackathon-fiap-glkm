package com.fiap.hackathon.global.relation.reservationadditional.pk;

import com.fiap.hackathon.aditional.entity.AdditionalEntity;
import com.fiap.hackathon.reservation.entity.ReservationEntity;
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
public class ReservationAdditionalPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "additional_id", nullable = false, foreignKey = @ForeignKey(name = "reservation_aditional_additional_id_additionals_id_fk"))
    private AdditionalEntity additional;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false, foreignKey = @ForeignKey(name = "reservation_aditional_reservation_id_reservations_id_fk"))
    private ReservationEntity reservation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationAdditionalPK that = (ReservationAdditionalPK) o;

        if (!Objects.equals(additional, that.additional)) return false;
        return Objects.equals(reservation, that.reservation);
    }

    @Override
    public int hashCode() {
        int result = additional != null ? additional.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }
}
