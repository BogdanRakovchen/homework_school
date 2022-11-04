package com.homework.homework_school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@OpenAPIDefinition

public class HomeworkSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSchoolApplication.class, args);
    }

}
