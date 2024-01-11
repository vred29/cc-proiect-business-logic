package com.amcr.appointments.spital;

import com.amcr.appointments.specializare.Specializare;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "SPITAL")
@Getter
@Setter
@NoArgsConstructor
public class Spital {
    @Id
    @GeneratedValue
    private Long id;

    private String nume;
    private String adresa;

    @ManyToMany(mappedBy = "spitale")
    private List<Specializare> specializari;
}
