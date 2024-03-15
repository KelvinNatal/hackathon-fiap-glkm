package com.fiap.hackathon.accomodation.entity;

import com.fiap.hackathon.property.entity.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accommodations")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer guests;

    @Column(nullable = false)
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
