package com.amcr.appointments.appointment.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class AdaugaAppointmentDto {
    private LocalDateTime dataProgramarii;
    private UUID spitalId;
    private UUID specializareId;
    private UUID medicId;
    private UUID pacientId;
}

