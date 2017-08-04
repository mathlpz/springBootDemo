package com.example.demo.common;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rabbitTemplate是springboot 提供的默认实现
 * @author lpz
 *
 */
@Component
public class HelloSender {

	@Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
        String context = "hello " + new Date();
        this.rabbitTemplate.convertAndSend("hello", context);
        
        System.out.println("Sender : " + context);
    }
	
}
