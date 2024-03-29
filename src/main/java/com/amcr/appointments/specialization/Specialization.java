package com.amcr.appointments.specialization;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.hospital.Hospital;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SPECIALIZATION")
@Getter
@Setter
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nume;

    @ManyToMany
    @JoinTable(
            name = "specialization_hospitals",
            joinColumns = @JoinColumn(name = "specialization_id"),
            inverseJoinColumns = @JoinColumn(name = "hospital_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "specialization_id", "hospital_id" })
    )
    private List<Hospital> spitale;

    @OneToMany(mappedBy = "specialization")
    private List<Appointment> appointments;
}
