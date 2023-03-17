package com.hb;

import com.hb.dao.VendorsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07DruidApplicationTests {

	@Autowired
	private VendorsDao vendorsDao;

	@Test
	void contextLoads() {
		System.out.println(vendorsDao.getVendorById(1001));
	}

}
