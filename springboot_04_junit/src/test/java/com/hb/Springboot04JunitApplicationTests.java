package com.hb;

import com.hb.Springboot04JunitApplication;
import com.hb.dao.BookDao;
import com.hb.dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot04JunitApplication.class)//这里引导是该类要在com.hb包或者他的子包下才不会报错
/**
 * 1.测试类如果存在于引导类所在包或子包中无需指定引导类
 * 2.测试类如果不存在于引导类所在的包或子包中需要通过classes属性指定引导类
 */
class Springboot04JunitApplicationTests {

    //1.注入对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
     bookDao.save();
    }

}
