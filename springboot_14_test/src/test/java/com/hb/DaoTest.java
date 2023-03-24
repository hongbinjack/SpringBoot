package com.hb;

import com.hb.dao.BookDao;
import com.hb.domain.Book;
import com.hb.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional  //与@SpringBootTest注解一起使用，使用之后测试类支持事务，测试可执行，但是不持久化
@Rollback(value = false)//默认是true，设置为false时，事务不回滚
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void save(){
        Book book = new Book();
        book.setDescription("description");
        book.setType("springboot");
        book.setName("hongbin");
        bookService.save(book);
    }


}
