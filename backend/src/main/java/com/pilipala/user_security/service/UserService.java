package com.pilipala.user_security.service;

import com.pilipala.user_security.dto.Response.UserResponseDTO;
import com.pilipala.user_security.dto.UserMapper;
import com.pilipala.user_security.entities.User;
import com.pilipala.user_security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserMapper::toDto);
    }

}
