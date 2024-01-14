package com.amcr.appointments.appointment.rest;

import com.amcr.appointments.appointment.AppointmentRepository;
import com.amcr.appointments.appointment.rest.dto.AppointmentDto;
import com.amcr.appointments.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/appointment")
@RestController
@RequiredArgsConstructor
public class AppointmentReadController {
    final AppointmentRepository appointmentRepository;
    final UserRepository userRepository;
    @GetMapping("/pacient")
    public List<AppointmentDto> getProgramariByPacient(@RequestParam UUID pacientId) throws BadRequestException {
        var pacient = userRepository.findById(pacientId)
                .orElseThrow(() -> new BadRequestException("Pacientul nu exista."));

        return appointmentRepository.findAllByPacient(pacient)
                .stream().map(AppointmentDto::new).toList();
    }

    @GetMapping("/medic")
    public List<AppointmentDto> getProgramariByMedic(@RequestParam UUID medicId) throws BadRequestException {
        var medic = userRepository.findById(medicId)
                .orElseThrow(() -> new BadRequestException("Medicul nu exista."));

        return appointmentRepository.findAllByMedic(medic)
                .stream().map(AppointmentDto::new).toList();
    }
}
