package com.hb;

import com.hb.config.MSGConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
/*
  在测试的时候，要用到外部的一些配置，并且这个配置只是在当前这个测试类使用，可以用@Import()注解将该配置类导入进来。
  因为不会在其他类中生效，所以可以有效地解决冲突问题，用于小范围的测试
 */
@Import(MSGConfig.class)//导入一个配置类MSGConfig
public class ConfigurationTest {

    @Autowired
    private MSGConfig msg;

    @Test
    void getMSG(){
        System.out.println(msg.getObject());
    }


}
