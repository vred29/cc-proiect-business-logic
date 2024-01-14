package com.amcr.appointments.specialization.rest;

import com.amcr.appointments.specialization.SpecializationRepository;
import com.amcr.appointments.specialization.rest.dto.SpecializationMinimalDto;
import com.amcr.appointments.hospital.Hospital;
import com.amcr.appointments.hospital.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/specialization")
@RestController
@RequiredArgsConstructor
public class SpecializationReadController {
    private final SpecializationRepository specializationRepository;
    private final HospitalRepository hospitalRepository;

    @GetMapping
    public List<SpecializationMinimalDto> getSpecializariBySpital(@RequestParam UUID spitalId) throws BadRequestException {
        Hospital hospital = hospitalRepository.findById(spitalId)
                .orElseThrow(() -> new BadRequestException("Spitalul nu exista."));
        return specializationRepository.findAllBySpitaleIn(List.of(hospital))
                .stream().map(SpecializationMinimalDto::new).toList();
    }
}
