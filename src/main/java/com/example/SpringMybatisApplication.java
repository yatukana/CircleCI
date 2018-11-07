package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisApplication.class, args);
    }
}
