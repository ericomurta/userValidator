package com.pilipala.user_security.dto;

import com.pilipala.user_security.dto.Request.UserRequestDTO;
import com.pilipala.user_security.dto.Response.UserResponseDTO;
import com.pilipala.user_security.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User entity = new User();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public static UserResponseDTO toDto(User entity) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        return dto;
    }
    public static void updateEntityFromDto(UserRequestDTO dto, User entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
    }




}
