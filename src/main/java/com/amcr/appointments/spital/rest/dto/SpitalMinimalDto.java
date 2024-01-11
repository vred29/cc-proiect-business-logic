package com.amcr.appointments.spital.rest.dto;

import com.amcr.appointments.spital.Spital;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class SpitalMinimalDto {
    private String id;
    private String nume;

    public SpitalMinimalDto(Spital spital){
        BeanUtils.copyProperties(spital, this);
    }
}
