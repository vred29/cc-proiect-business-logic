package com.amcr.appointments.user;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.user.rest.dto.AdaugaUserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String nume;
    private String prenume;

    private String cnp;

    private String adresa;

    private UserRole rol;

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

    public User(AdaugaUserDto dto){
        BeanUtils.copyProperties(dto, this);
    }

}
