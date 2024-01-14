package com.amcr.appointments.specialization.rest;

import com.amcr.appointments.specialization.SpecializationRepository;
import com.amcr.appointments.specialization.rest.dto.SpecializationMinimalDto;
import com.amcr.appointments.hospital.Hospital;
import com.amcr.appointments.hospital.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/specialization")
@RestController
@RequiredArgsConstructor
public class SpecializationReadController {
    private final SpecializationRepository specializationRepository;
    private final HospitalRepository hospitalRepository;

    @GetMapping
    public List<SpecializationMinimalDto> getSpecializariBySpital(@RequestBody UUID spitalId){
        Hospital hospital = hospitalRepository.findById(spitalId).orElse(null);
        return specializationRepository.findAllBySpitaleIn(List.of(hospital))
                .stream().map(SpecializationMinimalDto::new).toList();
    }
}
