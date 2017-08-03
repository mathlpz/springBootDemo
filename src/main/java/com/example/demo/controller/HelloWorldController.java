package com.example.demo.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

/**
 * @RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 * @author lpz
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
	
	@Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;
    
	
	@RequestMapping("/hello")
	public String index() {
		// 注入配置文件
		System.out.println(title);
		
		return "Hello World 1";
	}
	
	@RequestMapping("/redis")
    String redis() {
		// 缓存测试
		// 保存字符串
        stringRedisTemplate.opsForValue().set("name", "lpz");
        String string = stringRedisTemplate.opsForValue().get("name");
        System.out.println(string);

        // 保存对象
        User user = new User("超人", "12345", "111@111");
        redisTemplate.opsForValue().set(user.getUserName(), user);
        user = new User("蝙蝠侠", "12345", "222@222");
        redisTemplate.opsForValue().set(user.getUserName(), user);
        user = new User("蜘蛛侠", "12345", "333@333");
        redisTemplate.opsForValue().set(user.getUserName(), user);
        user = new User("ivms", "12345", "ivms7880@hikvison");
        redisTemplate.opsForValue().set(user.getUserName(), user);
        
        System.out.println(((User)redisTemplate.opsForValue().get("超人")).getEmail());
        System.out.println(((User)redisTemplate.opsForValue().get("蝙蝠侠")).getEmail());
        System.out.println(((User)redisTemplate.opsForValue().get("蜘蛛侠")).getEmail());
        System.out.println(((User)redisTemplate.opsForValue().get("ivms")).getEmail());
        
        return "redis test";
    }
	
	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
	
	
}