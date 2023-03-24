package com.hb;

import com.hb.testCase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/*
   properties属性仅对当前测试类生效
    这里可以在括号中对application.yml文件添加一个临时的属性，但是不会修改文件中的属性。
    这里的临时属性优先级大于配置属性，所以testProperties()方法输出：testValueTemporaryProperties
    @SpringBootTest(properties = {"test.pro = lastTestPro"})
 */

//args相当于在源码级别设置了配置属性，@Value < properties < args,args中的“--”要加，否则args设置不起作用
@SpringBootTest(properties = {"test.pro = TestValue2"},args = {"--test.pro = TestValue1"})
public class PropertiesAndArgsTest {

    @Value("${test.pro}")
    private String properties;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties(){
        System.out.println(properties);
        System.out.println(bookCase);
    }

}
