package com.amcr.appointments.specializare.rest;

import com.amcr.appointments.specializare.SpecializareRepository;
import com.amcr.appointments.specializare.rest.dto.SpecializareMinimalDto;
import com.amcr.appointments.spital.Spital;
import com.amcr.appointments.spital.SpitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/specializare")
@RestController
@RequiredArgsConstructor
public class SpecializareReadController {
    private final SpecializareRepository specializareRepository;
    private final SpitalRepository spitalRepository;

    @GetMapping
    public List<SpecializareMinimalDto> getSpecializariBySpital(@RequestBody Long spitalId){
        Spital spital = spitalRepository.findById(spitalId).orElse(null);
        return specializareRepository.findAllBySpitale(List.of(spital))
                .stream().map(SpecializareMinimalDto::new).toList();
    }
}
