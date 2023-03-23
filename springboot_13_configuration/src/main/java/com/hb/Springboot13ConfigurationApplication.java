package com.hb;

import com.alibaba.druid.pool.DruidDataSource;
import com.hb.config.ServerConfig;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@EnableConfigurationProperties(ServerConfig.class)
 这里使用了会与@Component冲突，创建两个相同的对象，NoUniqueBeanDefinitionException

 */
public class Springboot13ConfigurationApplication {

    @Bean //这段要在外面，在main方法里面会报错
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");//设置驱动类名，但此时还没有进行链接数据库，不需要导入依赖
        return ds;
    }

    public static void main(String[] args) {


    //等号右边初始化后得到一个容器对象，先拿到这个容器对象，设置容器对象的名字为ctx
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class);
        //从这个容器中获得该ServerConfig对象
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);

        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
//        System.out.println(ds);
        System.out.println(ds.getDriverClassName()); //获得mysql的驱动类名
    }

}
