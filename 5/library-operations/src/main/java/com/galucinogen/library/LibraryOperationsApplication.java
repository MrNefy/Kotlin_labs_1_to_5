package com.galucinogen.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryOperationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryOperationsApplication.class, args);
    }

    // 🔐 ВРЕМЕННО! Только для генерации bcrypt
    @Bean
    CommandLineRunner printPasswordHash(PasswordEncoder encoder) {
        return args -> {
            System.out.println("BCRYPT(password123) = " + encoder.encode("password123"));
        };
    }
}
