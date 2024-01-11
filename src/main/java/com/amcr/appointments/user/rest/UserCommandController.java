package com.amcr.appointments.user.rest;

import com.amcr.appointments.user.User;
import com.amcr.appointments.user.UserRepository;
import com.amcr.appointments.user.rest.dto.AdaugaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCommandController {
    private final UserRepository userRepository;
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody AdaugaUserDto dto){
        userRepository.save(new User(dto));
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}
