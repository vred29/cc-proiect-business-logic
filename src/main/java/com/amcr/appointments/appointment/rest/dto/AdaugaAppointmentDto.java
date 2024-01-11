package com.amcr.appointments.appointment.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AdaugaAppointmentDto {
    private LocalDateTime dataProgramarii;
    private Long spitalId;
    private Long specializareId;
    private Long medicId;
    private Long pacientId;
}

