package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@Configuration
@ComponentScan("com.example.demo")
@PropertySource("/application.properties")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class AppConfig {
    @Bean
    public Scanner initScanner() {
        return new Scanner(System.in);
    }
}
