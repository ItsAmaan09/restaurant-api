package com.example.restaurant.configuration;

import com.example.restaurant.model.User;
import com.example.restaurant.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("chef123"));
            user.setRole("ADMIN");
            userRepository.save(user);
            System.out.println("Test user created");
        }
    }
}
