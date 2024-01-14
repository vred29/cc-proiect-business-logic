package com.amcr.appointments.appointment;

import com.amcr.appointments.specialization.Specialization;
import com.amcr.appointments.hospital.Hospital;
import com.amcr.appointments.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "APPOINTMENT")
@Getter
@Setter
@Accessors(chain = true)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long numarProgramare;

    private LocalDateTime dataProgramarii;

    @ManyToOne
    private Hospital hospital;

    @ManyToOne
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "pacient_id")  // Specify the foreign key column for pacient
    private User pacient;

    @ManyToOne
    @JoinColumn(name = "medic_id")  // Specify the foreign key column for medic
    private User medic;
}
