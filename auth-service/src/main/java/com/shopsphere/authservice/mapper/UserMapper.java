package com.shopsphere.authservice.mapper;

import com.shopsphere.authservice.dto.RegisterRequestDTO;
import com.shopsphere.authservice.dto.RegisterResponseDTO;
import com.shopsphere.authservice.entity.User;

public class UserMapper {

    static public User toEntity(RegisterRequestDTO registerRequestDTO)
    {
        User user =new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setEmail(registerRequestDTO.getEmail());
        return user;
    }
    public static RegisterResponseDTO toResponseDTO(User user) {

        return new RegisterResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                "User registered successfully"
        );
    }
}
