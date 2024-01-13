package com.amcr.appointments.hospital;

import com.amcr.appointments.specialization.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SPITAL")
@Getter
@Setter
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nume;
    private String adresa;

    @ManyToMany(mappedBy = "spitale")
    private List<Specialization> specializari;
}
