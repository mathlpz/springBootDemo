package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.HelloWorldController;

/**
 * SpringBoot 提供一个注解@SpringBootTest，它能够测试你的SpringApplication，
 * 因为SpringBoot程序的入口是SpringApplication，基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置。
 * MOCK — 提供一个Mock的Servlet环境，内置的Servlet容器并没有真实的启动，主要搭配使用@AutoConfigureMockMvc 
 * RANDOM_PORT — 提供一个真实的Servlet环境，也就是说会启动内置容器，然后使用的是随机端口 
 * DEFINED_PORT — 这个配置也是提供一个真实的Servlet环境，使用的默认的端口，如果没有配置就是8080 
 * NONE — 这是个神奇的配置，跟Mock一样也不提供真实的Servlet环境。
 * @author lpz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
//@SpringBootTest(classes = MockServletContext.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
public class HelloWorldControlerTests {
	
    private MockMvc mvc;
    
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    
    @Test
    public void getHello() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/hello")
    		.accept(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andDo(MockMvcResultHandlers.print())
           .andReturn();
    }
}
