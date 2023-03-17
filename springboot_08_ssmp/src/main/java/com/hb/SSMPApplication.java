package com.hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {

        /**
             * 在edit configuration中的program argument里面填写的参数信息
             * 都存到了args这个数组中了
         */
//        System.out.println(Arrays.toString(args));
//        String[] arg = new String[1];
//        arg[0] ="--server.port = 8999";

        //可以在启动springboot程序时断开读取外部临时配置对应的入口，也就是去掉外部参数的形参
        SpringApplication.run(SSMPApplication.class);
    }

}
