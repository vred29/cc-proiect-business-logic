package com.amcr.appointments.appointment.rest;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.appointment.AppointmentRepository;
import com.amcr.appointments.appointment.rest.dto.AdaugaAppointmentDto;
import com.amcr.appointments.specialization.SpecializationRepository;
import com.amcr.appointments.hospital.HospitalRepository;
import com.amcr.appointments.user.UserRepository;
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
    final HospitalRepository hospitalRepository;
    final SpecializationRepository specializationRepository;
    final UserRepository userRepository;
    final AppointmentRepository appointmentRepository;
    @PostMapping
    public ResponseEntity<?> addAppointment(@RequestBody AdaugaAppointmentDto dto){
        var spital = hospitalRepository.findById(dto.getSpitalId()).orElse(null);
        var specializare = specializationRepository.findById(dto.getSpecializareId()).orElse(null);
        var medic = userRepository.findById(dto.getMedicId()).orElse(null);
        var pacient = userRepository.findById(dto.getPacientId()).orElse(null);

        appointmentRepository.save(
                new Appointment()
                        .setHospital(spital)
                        .setSpecialization(specializare)
                        .setMedic(medic)
                        .setPacient(pacient)
                        .setNumarProgramare(0L)
                        .setDataProgramarii(dto.getDataProgramarii())
        );

        return ResponseEntity.ok().build();
    }
}
