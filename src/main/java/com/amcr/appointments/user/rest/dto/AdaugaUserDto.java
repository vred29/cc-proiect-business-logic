package com.amcr.appointments.user.rest.dto;

import com.amcr.appointments.user.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdaugaUserDto {
    String nume;
    String prenume;
    String cnp;
    String adresa;
    String email;
    UserRole rol;
}
