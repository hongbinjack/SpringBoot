package com.hb;

import com.hb.dao.BookDao;
import com.hb.dao.VendorsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Springboot05MybatisPlusApplicationTests {

	@Autowired
    private VendorsDao vendorsDao;

	@Autowired
	private BookDao bookDao;
	@Test
	void getSingleById(){
		System.out.println(vendorsDao.selectById(1001));
	}

	@Test
	void getAllById(){
		System.out.println(vendorsDao.selectList(null));}

	@Test
	void testGetBookById(){
		System.out.println(bookDao.selectById(1));
	}
}
