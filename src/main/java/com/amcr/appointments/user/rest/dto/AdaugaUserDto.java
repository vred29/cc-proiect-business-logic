package com.amcr.appointments.user.rest.dto;

import com.amcr.appointments.user.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdaugaUserDto {
    String email;

    String nume;
    String prenume;

    String cnp;

    String adresa;

    UserRole rol;
}
