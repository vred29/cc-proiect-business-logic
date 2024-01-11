package com.amcr.appointments.appointment;

import com.amcr.appointments.specializare.Specializare;
import com.amcr.appointments.spital.Spital;
import com.amcr.appointments.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Table(name = "APPOINTMENT")
@Getter
@Setter
@Accessors(chain = true)
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    private Long numarProgramare;

    private LocalDateTime dataProgramarii;

    @ManyToOne
    private Spital spital;

    @ManyToOne
    private Specializare specializare;

    @ManyToOne
    private User pacient;

    @ManyToOne
    private User medic;
}
