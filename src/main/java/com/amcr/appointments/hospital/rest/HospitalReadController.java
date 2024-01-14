package com.amcr.appointments.hospital.rest;

import com.amcr.appointments.hospital.HospitalRepository;
import com.amcr.appointments.hospital.rest.dto.HospitalMinimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/hospital")
@RestController
@RequiredArgsConstructor
public class HospitalReadController {
    final HospitalRepository hospitalRepository;

    @GetMapping
    public List<HospitalMinimalDto> getAllSpitale(){
        return hospitalRepository.findAll()
                .stream().map(HospitalMinimalDto::new).toList();
    }
}
