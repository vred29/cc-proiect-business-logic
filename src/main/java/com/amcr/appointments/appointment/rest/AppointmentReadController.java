package com.amcr.appointments.appointment.rest;

import com.amcr.appointments.appointment.AppointmentRepository;
import com.amcr.appointments.appointment.rest.dto.AppointmentDto;
import com.amcr.appointments.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/appointment")
@RestController
@RequiredArgsConstructor
public class AppointmentReadController {
    final AppointmentRepository appointmentRepository;
    final UserRepository userRepository;
    @GetMapping("/pacient")
    public List<AppointmentDto> getProgramariByPacient(@RequestBody UUID pacientId){
        var pacient = userRepository.findById(pacientId).orElse(null);
        return appointmentRepository.findAllByPacient(pacient)
                .stream().map(AppointmentDto::new).toList();
    }

    @GetMapping("/medic")
    public List<AppointmentDto> getProgramariByMedic(@RequestBody UUID medicId){
        var pacient = userRepository.findById(medicId).orElse(null);
        return appointmentRepository.findAllByPacient(pacient)
                .stream().map(AppointmentDto::new).toList();
    }
}
