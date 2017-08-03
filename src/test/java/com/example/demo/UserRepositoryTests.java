package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTests {
 
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
         
        userRepository.save(new User("aa1", "aa", "aa@126.com", "aa123456", formattedDate));
        userRepository.save(new User("bb2", "bb", "bb@126.com", "bb123456", formattedDate));
        userRepository.save(new User("cc3", "cc", "cc@126.com", "cc123456", formattedDate));
 
        Assert.assertEquals(9, userRepository.findAll().size());
        
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        
        userRepository.delete(userRepository.findByUserName("aa1"));
        
    }
 
}
