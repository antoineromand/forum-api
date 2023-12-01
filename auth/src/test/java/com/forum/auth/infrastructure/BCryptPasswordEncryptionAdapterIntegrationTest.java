package com.forum.auth.infrastructure;

import com.forum.auth.infrastructure.adapters.BCryptPasswordEncryptionAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class BCryptPasswordEncryptionAdapterIntegrationTest {

    @Test
    void shouldEncryptString() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BCryptPasswordEncryptionAdapter adapter = new BCryptPasswordEncryptionAdapter(passwordEncoder);

        String rawPassword = "123456";
        String encryptedPassword = adapter.encryptPassword(rawPassword);

        assertNotNull(encryptedPassword, "The encrypted password should not be null");
        assertNotEquals(rawPassword, encryptedPassword, "The encrypted password should not be the same as the raw password");
    }
}
