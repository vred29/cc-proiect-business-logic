package com.amcr.appointments.spital.rest;

import com.amcr.appointments.spital.SpitalRepository;
import com.amcr.appointments.spital.rest.dto.SpitalMinimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/spitale")
@RestController
@RequiredArgsConstructor
public class SpitalReadController {
    private SpitalRepository spitalRepository;

    @GetMapping
    public List<SpitalMinimalDto> getAllSpitale(){
        return spitalRepository.findAll()
                .stream().map(SpitalMinimalDto::new).toList();
    }
}
