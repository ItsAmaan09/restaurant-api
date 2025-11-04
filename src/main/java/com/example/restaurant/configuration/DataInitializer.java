package com.example.restaurant.configuration;

import com.example.restaurant.model.User;
import com.example.restaurant.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder encoder){
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("chef123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);

                User customer = new User();
                customer.setUsername("customer");
                customer.setPassword(encoder.encode("cust123"));
                admin.setRole("CUSTOMER");
                userRepository.save(customer);
            }
        };
    }
}
