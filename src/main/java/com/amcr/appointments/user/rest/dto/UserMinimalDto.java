package com.amcr.appointments.user.rest.dto;

import com.amcr.appointments.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
public class UserMinimalDto {
    UUID id;
    String nume;
    String prenume;

    public UserMinimalDto(User user){
        BeanUtils.copyProperties(user, this);
    }
}
