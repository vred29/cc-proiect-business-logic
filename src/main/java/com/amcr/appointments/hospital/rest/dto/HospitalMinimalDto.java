package com.amcr.appointments.hospital.rest.dto;

import com.amcr.appointments.hospital.Hospital;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class HospitalMinimalDto {
    private String id;
    private String nume;

    public HospitalMinimalDto(Hospital hospital){
        BeanUtils.copyProperties(hospital, this);
    }
}
