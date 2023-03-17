package com.hb;

import com.hb.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class,args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println("bean======>" + bean);
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}
