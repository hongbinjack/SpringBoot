package com.hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启缓存功能的注解
public class Springboot18CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18CacheApplication.class, args);
    }

}
