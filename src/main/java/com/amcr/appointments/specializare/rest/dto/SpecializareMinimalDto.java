package com.amcr.appointments.specializare.rest.dto;

import com.amcr.appointments.specializare.Specializare;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class SpecializareMinimalDto {
    private String id;
    private String nume;

    public SpecializareMinimalDto(Specializare specializare){
        BeanUtils.copyProperties(specializare, this);
    }
}
