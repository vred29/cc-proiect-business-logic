package com.amcr.appointments.user.rest.dto;

import com.amcr.appointments.user.User;
import com.amcr.appointments.user.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID id;
    private String email;
    private String nume;
    private String prenume;
    private String cnp;
    private String adresa;
    private UserRole rol;

    public UserDto(User user){
        BeanUtils.copyProperties(user, this);
    }
}