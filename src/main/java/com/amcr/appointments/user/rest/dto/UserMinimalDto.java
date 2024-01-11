package com.amcr.appointments.user.rest.dto;

import com.amcr.appointments.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class UserMinimalDto {
    String id;
    String nume;
    String prenume;

    public UserMinimalDto(User user){
        BeanUtils.copyProperties(user, this);
    }
}
