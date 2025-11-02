package com.pilipala.user_security.service;

import com.pilipala.user_security.dto.Request.UserRequestDTO;
import com.pilipala.user_security.dto.Response.UserResponseDTO;
import com.pilipala.user_security.dto.UserMapper;
import com.pilipala.user_security.entities.User;
import com.pilipala.user_security.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserMapper::toDto);
    }

    public UserResponseDTO findById(Long id){
        return userRepository.findById(id)
                .map(UserMapper::toDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserResponseDTO createUser(UserResponseDTO userResponseDTO){
        User entity = new User();
        entity.setNome(userResponseDTO.getNome());
        entity.setEmail(userResponseDTO.getEmail());
        entity = userRepository.save(entity);
        return UserMapper.toDto(entity);
    }

    public UserResponseDTO userUpdate(Long id, UserRequestDTO userRequestDTO) {
        try {
            User entity = userRepository.findById(id)
                            .orElseThrow(()-> new RuntimeException("User not Found!"));
            UserMapper.updateEntityFromDto(userRequestDTO, entity);
            entity = userRepository.save(entity);
            return UserMapper.toDto(entity);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public void  deleteUser(Long id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
