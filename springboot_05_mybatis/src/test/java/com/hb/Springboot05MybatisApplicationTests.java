package com.hb;

import com.hb.dao.VendorsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

	@Autowired
	private VendorsDao vendorsDao;

	@Test
	void getData() {

		System.out.println(vendorsDao.getVendorById(1002));
	}

	@Test
	void updateById(){
		vendorsDao.updateById(1001);
	}

	@Test
	void insertData(){
		vendorsDao.insertData();
	}

	@Test
	void deleteData(){
     vendorsDao.deleteData(1009);
	}

	//已实现了增删改查四步走
}
