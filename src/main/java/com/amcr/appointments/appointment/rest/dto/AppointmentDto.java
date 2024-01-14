package com.amcr.appointments.appointment.rest.dto;

import com.amcr.appointments.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDto {
    private String id;
    private Long numarProgramare;
    private LocalDateTime dataProgramarii;
    public AppointmentDto(Appointment appointment){
        BeanUtils.copyProperties(appointment, this);
    }

}
