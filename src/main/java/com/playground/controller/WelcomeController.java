package com.playground.controller;

import com.google.common.collect.Lists;
import com.playground.domain.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public List<UserDTO> index() {
        return Lists.newArrayList(
                new UserDTO(UUID.randomUUID(), "john.perry", "john.perry@gmail.com", LocalDateTime.now()),
                new UserDTO(UUID.randomUUID(), "ana.johnson", "ana.johnson@gmail.com", LocalDateTime.now())
//                new UserDTO(UUID.randomUUID(), "ruth.kane", " ruth.kane@gmail.com", LocalDateTime.now()),
//                new UserDTO(UUID.randomUUID(), "paul.jackson", "paul.jackson@gmail.com", LocalDateTime.now()),
//                new UserDTO(UUID.randomUUID(), "joshuel.phillips", "joshuel.phillips@gmail.com", LocalDateTime.now())
        );
    }

}
