package com.shopsphere.authservice.service;

import com.shopsphere.authservice.dto.RegisterRequestDTO;
import com.shopsphere.authservice.dto.RegisterResponseDTO;
import com.shopsphere.authservice.entity.User;
import com.shopsphere.authservice.exception.EmailAlreadyExistsException;
import com.shopsphere.authservice.exception.UsernameAlreadyExistsException;
import com.shopsphere.authservice.mapper.UserMapper;
import com.shopsphere.authservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email Already Exists");
        }

        if (userRepository.existsByUsername(registerRequestDTO.getUsername())) {
            throw new UsernameAlreadyExistsException("UserName Already Exists");
        }

        User user = UserMapper.toEntity(registerRequestDTO);

        String encodedPassword =
                passwordEncoder.encode(registerRequestDTO.getPassword());

        user.setPassword(encodedPassword);
        user.setRole("USER");

        User savedUser = userRepository.save(user);

        return UserMapper.toResponseDTO(savedUser);
    }

}