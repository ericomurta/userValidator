package com.pilipala.user_security.controller;

import com.pilipala.user_security.dto.Response.UserResponseDTO;
import com.pilipala.user_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> findAll(Pageable pageable) {
        return  ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity <Optional<UserResponseDTO>> findByiD(@PathVariable Long id){
        Optional<UserResponseDTO> dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }







}
