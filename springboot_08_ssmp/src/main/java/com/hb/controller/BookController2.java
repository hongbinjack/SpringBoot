package com.hb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hb.domain.Book;
import com.hb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping//基本上所有的查询请求都是用Get请求
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    //此处设置删除操作用路径变量，如：http://localhost/books/2   意思是删除id为2的数据
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    //此处设置查询操作用路径变量，如：http://localhost/books/5 意思是查询id为5数据信息
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    //设置泛型为IPage意思是返回的类型是一页一页的
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        //在postMan里面输入：http://localhost/books/1/10 意思是查询第一页，每一页显示十条

        return bookService.getPage(currentPage,pageSize, null);
    }

}

















