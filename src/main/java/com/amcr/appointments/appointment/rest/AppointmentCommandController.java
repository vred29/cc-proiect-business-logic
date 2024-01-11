package com.amcr.appointments.appointment.rest;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.appointment.AppointmentRepository;
import com.amcr.appointments.appointment.rest.dto.AdaugaAppointmentDto;
import com.amcr.appointments.specializare.SpecializareRepository;
import com.amcr.appointments.spital.Spital;
import com.amcr.appointments.spital.SpitalRepository;
import com.amcr.appointments.user.User;
import com.amcr.appointments.user.UserRepository;
import com.amcr.appointments.user.rest.dto.AdaugaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/appointment")
@RestController
@RequiredArgsConstructor
public class AppointmentCommandController {
    final SpitalRepository spitalRepository;
    final SpecializareRepository specializareRepository;
    final UserRepository userRepository;
    final AppointmentRepository appointmentRepository;
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody AdaugaAppointmentDto dto){
        var spital = spitalRepository.findById(dto.getSpitalId()).orElse(null);
        var specializare = specializareRepository.findById(dto.getSpecializareId()).orElse(null);
        var medic = userRepository.findById(dto.getMedicId()).orElse(null);
        var pacient = userRepository.findById(dto.getPacientId()).orElse(null);

        appointmentRepository.save(
                new Appointment()
                        .setSpital(spital)
                        .setSpecializare(specializare)
                        .setMedic(medic)
                        .setPacient(pacient)
                        .setNumarProgramare(0L)
                        .setDataProgramarii(dto.getDataProgramarii())
        );

        return ResponseEntity.ok().build();
    }
}
