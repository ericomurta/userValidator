package com.pilipala.user_security.controller;

import com.pilipala.user_security.dto.Response.UserResponseDTO;
import com.pilipala.user_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public ResponseEntity<Page<UserResponseDTO>> findAll(Pageable pageable) {
        return  ResponseEntity.ok(userService.findAll(pageable));
    }









}
