package com.example.demo.common;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 队列配置
 * @author lpz
 *
 */
@Configuration
public class RabbitConfig {
 
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
 
}