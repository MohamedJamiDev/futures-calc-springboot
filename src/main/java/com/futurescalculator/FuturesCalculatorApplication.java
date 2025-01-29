package com.futurescalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.futurescalculator.repository")
public class FuturesCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FuturesCalculatorApplication.class, args);
    }
}