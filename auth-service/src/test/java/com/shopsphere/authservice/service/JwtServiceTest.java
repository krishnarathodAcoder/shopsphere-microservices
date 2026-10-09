package com.shopsphere.authservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        byte[] keyBytes = new byte[32];

        for (int i = 0; i < keyBytes.length; i++) {
            keyBytes[i] = (byte) (i + 1);
        }

        String testSecret =
                Base64.getEncoder().encodeToString(keyBytes);

        jwtService = new JwtService(testSecret, 3600000);
    }

    @Test
    void shouldGenerateToken() {
        String token =
                jwtService.generateToken(101L, "krishna", "USER");

        assertNotNull(token);
        assertTrue(token.split("\\.").length == 3);
    }
}