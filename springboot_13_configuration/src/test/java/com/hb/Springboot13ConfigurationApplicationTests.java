package com.hb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ConfigurationApplicationTests {


    @Value("${servers.ipAddress}")//它不支持随意匹配，小数点后面的变量必须和配置文件中的变量相同，即不支持松散绑定
    private String msg;
    @Value("${servers.serverTimeout}")
    private long serverTimeout;
    @Value("${servers.dataSize}")
    private String dataSize; //因为后来改成了10改成了10MB，所以整型直接变成了字符串，一直报错。要注意

    @Test
    void contextLoads() {
        System.out.println(msg);

        System.out.println(serverTimeout);

        System.out.println(dataSize);
    }



    @Value("${datasource.password}")
    private String password;
    @Test
    void getPwd(){

        System.out.println(password);
    }




}
