package com.amcr.appointments.specialization.rest.dto;

import com.amcr.appointments.specialization.Specialization;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
public class SpecializationMinimalDto {
    private UUID id;
    private String nume;

    public SpecializationMinimalDto(Specialization specialization){
        BeanUtils.copyProperties(specialization, this);
    }
}
