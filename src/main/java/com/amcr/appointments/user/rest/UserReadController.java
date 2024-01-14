package com.amcr.appointments.user.rest;

import com.amcr.appointments.user.User;
import com.amcr.appointments.user.UserRepository;
import com.amcr.appointments.user.UserRole;
import com.amcr.appointments.user.rest.dto.UserMinimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserReadController {
    private final UserRepository userRepository;


    @GetMapping("/{userId}")
    public User getUser(@PathVariable UUID userId){
        return userRepository.findById(userId).orElse(null);
    }

    @GetMapping("/medici")
    public List<UserMinimalDto> getMedici(){
        return userRepository
                .findAllByRol(UserRole.CADRU_MEDICAL)
                .stream().map(UserMinimalDto::new).toList();
    }

}
