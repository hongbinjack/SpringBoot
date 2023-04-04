package com.hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot19TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot19TaskApplication.class, args);
    }

}
