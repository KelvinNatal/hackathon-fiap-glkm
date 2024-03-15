package com.fiap.hackathon.entities;

import com.fiap.hackathon.pks.ReservationExtraServicePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reservation_extra_service")
public class ReservationExtraServiceRelation {

    @Autowired
    @EmbeddedId
    ReservationExtraServicePK reservationExtraServicePK = new ReservationExtraServicePK();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationExtraServiceRelation that = (ReservationExtraServiceRelation) o;

        return reservationExtraServicePK.equals(that.reservationExtraServicePK);
    }

    @Override
    public int hashCode() {
        return reservationExtraServicePK.hashCode();
    }
}
