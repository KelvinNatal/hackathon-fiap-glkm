package com.fiap.hackathon.aditional.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Additionals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdditionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAdditional;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal cost;

}
