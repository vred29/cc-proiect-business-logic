package com.amcr.appointments.appointment.rest;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.appointment.AppointmentRepository;
import com.amcr.appointments.appointment.rest.dto.AdaugaAppointmentDto;
import com.amcr.appointments.specialization.SpecializationRepository;
import com.amcr.appointments.hospital.HospitalRepository;
import com.amcr.appointments.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/appointment")
@RestController
@RequiredArgsConstructor
public class AppointmentCommandController {
    final HospitalRepository hospitalRepository;
    final SpecializationRepository specializationRepository;
    final UserRepository userRepository;
    final AppointmentRepository appointmentRepository;

    private Long generateRandomLong() {
        Random random = new Random();
        return (long) random.nextInt();
    }
    @PostMapping
    public ResponseEntity<?> addAppointment(@RequestBody AdaugaAppointmentDto dto) throws BadRequestException {
        var spital = hospitalRepository.findById(dto.getSpitalId())
                .orElseThrow(() -> new BadRequestException("Spitalul nu exista."));
        var specializare = specializationRepository.findById(dto.getSpecializareId())
                .orElseThrow(() -> new BadRequestException("Specializarea nu exista."));
        var medic = userRepository.findById(dto.getMedicId())
                .orElseThrow(() -> new BadRequestException("Medicul nu exista."));
        var pacient = userRepository.findById(dto.getPacientId())
                .orElseThrow(() -> new BadRequestException("Pacientul nu exista."));

        var appointment = appointmentRepository.save(
                new Appointment()
                        .setHospital(spital)
                        .setSpecialization(specializare)
                        .setMedic(medic)
                        .setPacient(pacient)
                        .setNumarProgramare(generateRandomLong())
                        .setDataProgramarii(dto.getDataProgramarii())
        );

        return ResponseEntity.ok(appointment.getId());
    }
}
