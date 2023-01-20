package ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@OpenAPIDefinition
public class SchoolApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SchoolApplication.class, args);
    }

}
