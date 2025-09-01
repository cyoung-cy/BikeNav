package com.example.bikenavbackend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        String ddl = """
            CREATE TABLE IF NOT EXISTS users (
              id BIGINT PRIMARY KEY AUTO_INCREMENT,
              name VARCHAR(100) NOT NULL,
              email VARCHAR(255) NOT NULL UNIQUE,
              password_hash VARCHAR(255) NOT NULL,
              created_at DATETIME NOT NULL,
              updated_at DATETIME NOT NULL
            );
            """;
        jdbcTemplate.execute(ddl);
    }
}
