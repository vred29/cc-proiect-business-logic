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

@RequestMapping("/appointments")
@RestController
@RequiredArgsConstructor
public class AppointmentReadController {
    final AppointmentRepository appointmentRepository;
    final UserRepository userRepository;
    @GetMapping
    public List<AppointmentDto> getProgramariByPacient(@RequestBody Long pacientId){
        var pacient = userRepository.findById(pacientId).orElse(null);
        return appointmentRepository.findAllByPacient(pacient)
                .stream().map(AppointmentDto::new).toList();
    }

    @GetMapping
    public List<AppointmentDto> getProgramariByMedic(@RequestBody Long medicId){
        var pacient = userRepository.findById(medicId).orElse(null);
        return appointmentRepository.findAllByPacient(pacient)
                .stream().map(AppointmentDto::new).toList();
    }
}
