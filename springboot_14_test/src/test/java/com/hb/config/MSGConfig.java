package com.hb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MSGConfig {

    @Bean
    public String getObject(){
        return "String Object!";
    }
}
