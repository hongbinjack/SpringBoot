package com.hb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//在注解中使用webEnvironment就可以使测试类启用Web环境，DEFINED_PORT：默认端口    RANDOM_PORT:随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC的调用
@AutoConfigureMockMvc
public class WebTest {

    @Test//虚拟请求测试
    void testWeb(@Autowired MockMvc mvc) throws Exception {//括号中传入了这些参数就可以在该方法中使用虚拟调用的对象了

        //创建虚拟请求，当前访问/books   模拟了一次http请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行对应请求
        ResultActions resultActions = mvc.perform(builder);
    }

    @Test//虚拟请求状态匹配,测试实际请求路径是否和我们预期的请求路径一致. 测试执行状态的匹配
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions= mvc.perform(builder);

        //匹配执行状态（是否预期值）
        //定义执行状态匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //定义与其执行状态，预期是200即执行成功
        ResultMatcher ok = status.isOk();
        //使用本次真实执行结果与预期结果进行比对
        actions.andExpect(ok);
    }


    @Test //测试实际返回结果是否和我们预期的返回结果一致。  测试执行内容的匹配
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");

        ResultActions actions= mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();


        ResultMatcher body = content.string("springboot is return");

        actions.andExpect(body);
    }

    @Test //测试实际返回的json数据是否和我们预期的返回结果一致。
    void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");

        ResultActions actions= mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();


        ResultMatcher json = content.json("{\"id\":1,\"type\":\"framework\",\"name\":\"springboot\",\"description\":\"get it springboot\"}");

        actions.andExpect(json);
    }

    @Test//模拟测试用三种方式
    void testGetById(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":1,\"type\":\"framework\",\"name\":\"springboot\",\"description\":\"get it springboot\"}");
        action.andExpect(result);

    }

}
