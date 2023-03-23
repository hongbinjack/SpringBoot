package com.hb.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 目前做的程序都是spring程序，都要受spring管理（spring是用来管理Bean的），这里使用spring
 * 来管理第三方Bean的方式来把第三方Bean初始化出来，并且加载给spring的环境
 *
 * 总的来说这个程序交给了spring管理的一个Bean，这个Bean是MybatisPlusInterceptor的拦截器，
 * 这个拦截器里面有一个"interceptor.addInnerInterceptor(new PaginationInnerInterceptor())"
 * 这么个具体的拦截器
 */
@Configuration//注解该类是一个配置类
//配置了一个分页的拦截器
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //创建拦截器对象，但只是一个拦截器的壳，并没有放入拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加内部的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
