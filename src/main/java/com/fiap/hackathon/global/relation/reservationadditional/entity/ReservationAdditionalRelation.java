package com.fiap.hackathon.global.relation.reservationadditional.entity;

import com.fiap.hackathon.global.relation.reservationadditional.pk.ReservationAdditionalPK;
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
@Table(name = "reservation_additional")
public class ReservationAdditionalRelation {

    @Autowired
    @EmbeddedId
    ReservationAdditionalPK reservationAdditionalPK = new ReservationAdditionalPK();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationAdditionalRelation that = (ReservationAdditionalRelation) o;

        return reservationAdditionalPK.equals(that.reservationAdditionalPK);
    }

    @Override
    public int hashCode() {
        return reservationAdditionalPK.hashCode();
    }
}
