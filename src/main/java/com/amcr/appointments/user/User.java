package com.amcr.appointments.user;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.user.rest.dto.AdaugaUserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "APPOINTMENT_USER")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;

    private String nume;
    private String prenume;

    private String cnp;

    private String adresa;

    private UserRole rol;

    @OneToMany(mappedBy = "pacient")
    private List<Appointment> pacientAppointments;

    @OneToMany(mappedBy = "medic")
    private List<Appointment> medicAppointments;

    public User(AdaugaUserDto dto){
        BeanUtils.copyProperties(dto, this);
    }

}
