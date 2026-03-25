package com.example.DemoDevopsPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoDevopsPracticeApplication{

    @GetMapping("/hello")
    public String hello() {
        return "Hello Raju-- Your Dockerized Java App is ready for deployment 🚀";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoDevopsPracticeApplication.class, args);
    }
}

