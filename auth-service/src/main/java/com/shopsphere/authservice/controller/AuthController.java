package com.shopsphere.authservice.controller;

import com.shopsphere.authservice.dto.RegisterRequestDTO;
import com.shopsphere.authservice.dto.RegisterResponseDTO;
import com.shopsphere.authservice.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO)
    {
       RegisterResponseDTO registerResponseDTO=  authService.registerUser(registerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registerResponseDTO);
    }
}
