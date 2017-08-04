package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 *修改容器的默认配置信息，比如端口号
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		
//		container.setAddress(address);
		container.setPort(8888);
	}
	 
	
}
