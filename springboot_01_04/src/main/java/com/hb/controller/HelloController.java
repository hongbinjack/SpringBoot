package com.hb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("helloController")
@RestController
public class HelloController {
    @GetMapping
    public String handle()
    {
        System.out.println("今天天气很好！");
        return "helloController";
    }
}
