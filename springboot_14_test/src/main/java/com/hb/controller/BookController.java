package com.hb.controller;


import com.hb.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("springboot is running");
//        return "springboot is return";
//    }
    @GetMapping
    public Book getById(){
        System.out.println("springboot is running");

        Book book = new Book();
        book.setName("springboot");
        book.setType("framework");
        book.setId(1);
        book.setDescription("get it springboot");
        return book;
    }
}
