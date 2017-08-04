package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

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
    
    @Test
    public void testBaseQuery() throws Exception {
        User user=new User();
        userRepository.findAll();
        userRepository.findOne(1l);
        userRepository.save(user);
        userRepository.delete(user);
        userRepository.count();
        userRepository.exists(1l);
        // ...
    }
    
    @Test
    public void testPageQuery() throws Exception {
        int page=1,size=10;
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
//        userRepository.findALL(pageable);
//        List<User> userList = userRepository.findByUserName("testName", pageable);
    }
    
 
}
