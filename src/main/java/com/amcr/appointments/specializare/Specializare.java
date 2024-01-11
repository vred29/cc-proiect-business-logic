package com.amcr.appointments.specializare;

import com.amcr.appointments.spital.Spital;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "SPECIALIZARE")
@Getter
@Setter
@NoArgsConstructor
public class Specializare {
    @Id
    @GeneratedValue
    private Long id;

    private String nume;

    @ManyToMany
    private List<Spital> spitale;
}
