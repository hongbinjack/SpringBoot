package com.hb;

import com.hb.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

    @Test
	void testMongodb(){
		Book book = new Book();
		book.setId(2);
		book.setName("springboot88");
		book.setDescription("springboot99");
        book.setType("skill66");
		mongoTemplate.save(book);
	}

      @Test
	void findAll(){
		  List<Book> all = mongoTemplate.findAll(Book.class);
		  System.out.println(all);
	  }

}
