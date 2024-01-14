package com.amcr.appointments.user.rest;

import com.amcr.appointments.user.User;
import com.amcr.appointments.user.UserRepository;
import com.amcr.appointments.user.rest.dto.AdaugaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCommandController {
    final UserRepository userRepository;
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody AdaugaUserDto dto){
        var user = userRepository.save(new User(dto));
        return ResponseEntity.ok(user.getId());

    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId){
        userRepository.deleteById(userId);
    }
}
