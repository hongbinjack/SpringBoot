package com.hb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@Data
/*
  prefix 表示该属性(类)对应的上一级名称，即该类加载时将application.yml中的值分别赋值给这个类
  变量名相同的变量，我认为是相当于从一个文件读取相同名称的变量值，赋值到我这个类中对应的属性
 */
@ConfigurationProperties(prefix = "servers")
   //开启对当前Bean的属性校验
@Validated  //@Max和@Min这两个校验和这个注解有关联
public class ServerConfig {

    private String ipAddress;
    //设置具体的属性规则，对应的实参在application.yml中
    @Max(value = 8888,message = "最大值不能超过8888")
    @Min(value = 88,message = "最小值不能超过88")
    private int port;
    private long timeout;

    @DurationUnit(ChronoUnit.MILLIS)//设置Duration类型的变量时间单位，这是设置的是毫秒
    private Duration serverTimeout;

  //设置DataSizeUnit类型的变量的容量大小单位，这里设置的是MB,下面这行可以省略，在配置文件中直接写MB,G,T即可
  @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;



}
