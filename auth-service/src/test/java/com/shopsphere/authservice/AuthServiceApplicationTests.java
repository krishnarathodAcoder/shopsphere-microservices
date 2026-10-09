package com.shopsphere.authservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(properties = {
        "jwt.secret=AAECAwQFBgcICQoLDA0ODxAREhMUFRYXGBkaGxwdHh8=",
        "jwt.expiration-ms=3600000"
})
class AuthServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
