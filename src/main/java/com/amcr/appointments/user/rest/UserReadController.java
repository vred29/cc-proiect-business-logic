package com.amcr.appointments.user.rest;

import com.amcr.appointments.user.UserRepository;
import com.amcr.appointments.user.UserRole;
import com.amcr.appointments.user.rest.dto.UserDto;
import com.amcr.appointments.user.rest.dto.UserMinimalDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserReadController {
    final UserRepository userRepository;

    @GetMapping
    public List<UserDto> getAll(){
        return userRepository
                .findAll()
                .stream()
                .map(UserDto::new).toList();
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable UUID userId) throws BadRequestException {
        return userRepository
                .findById(userId)
                .map(UserDto::new)
                .orElseThrow(() -> new BadRequestException("User-ul nu exista."));
    }

    @GetMapping("/medici")
    public List<UserMinimalDto> getMedici(){
        return userRepository
                .findAllByRol(UserRole.CADRU_MEDICAL)
                .stream().map(UserMinimalDto::new).toList();
    }

}
